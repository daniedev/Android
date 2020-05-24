package com.mobileapp.learnkotlin.codelabs.trackmysleepquality.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.mobileapp.learnkotlin.codelabs.trackmysleepquality.database.SleepDatabaseDao
import com.mobileapp.learnkotlin.codelabs.trackmysleepquality.database.SleepNight
import com.mobileapp.learnkotlin.codelabs.trackmysleepquality.formatNights
import kotlinx.coroutines.*

/**
 * ViewModel for SleepTrackerFragment.
 */
class SleepTrackerViewModel(
    val database: SleepDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val nights = database.getAllNights()
    private var tonight = MutableLiveData<SleepNight?>()

    val nightsString = Transformations.map(nights) { nights ->
        formatNights(nights, application.resources)
    }

    private val _navigateToSleepQuality = MutableLiveData<SleepNight>()
    val navigateToSleepQuality: LiveData<SleepNight>
        get() = _navigateToSleepQuality

    private val _showSnackBarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackBarEvent

    val startButtonVisible = Transformations.map(tonight) { it == null }
    val stopButtonVisible = Transformations.map(tonight) { it != null }
    val clearButtonVisible = Transformations.map(nights) { it?.isNotEmpty() }

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        uiScope.launch { tonight.value = getTonightFromDatabase() }
    }

    private suspend fun getTonightFromDatabase(): SleepNight? {
        return withContext(Dispatchers.IO) {
            var night = database.getTonight()
            if (night?.startTimeMilli != night?.endTimeMilli)
                night = null
            night
        }
    }

    fun onStartTracking() {
        uiScope.launch {
            val newNight = SleepNight()
            insert(newNight)
            tonight.value = getTonightFromDatabase()
        }

    }

    fun onStopTracking() {
        uiScope.launch {
            val oldNight = tonight.value ?: return@launch
            oldNight.endTimeMilli = System.currentTimeMillis()
            update(oldNight)
            _navigateToSleepQuality.value = oldNight
        }
    }

    fun onClear() {
        uiScope.launch {
            clear()
            _showSnackBarEvent.value = true
            tonight.value = null
        }
    }

    fun doneNavigating() {
        _navigateToSleepQuality.value = null
    }

    fun doneShowingSnackBar() {
        _showSnackBarEvent.value = false
    }

    private suspend fun insert(newNight: SleepNight) {
        withContext(Dispatchers.IO) {
            database.insert(newNight)
        }
    }

    private suspend fun update(oldNight: SleepNight) {
        withContext(Dispatchers.IO) {
            database.update(oldNight)
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

