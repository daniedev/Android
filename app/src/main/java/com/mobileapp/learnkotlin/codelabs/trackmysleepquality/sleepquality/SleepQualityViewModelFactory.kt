package com.mobileapp.learnkotlin.codelabs.trackmysleepquality.sleepquality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobileapp.learnkotlin.codelabs.trackmysleepquality.database.SleepDatabaseDao

@Suppress("UNCHECKED_CAST")
class SleepQualityViewModelFactory(
    private val sleepNightKey: Long,
    private val dataSource: SleepDatabaseDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SleepQualityViewModel::class.java))
            return SleepQualityViewModel(sleepNightKey, dataSource) as T
        else
            throw IllegalArgumentException("Unknown ViewModel Class!!")
    }
}
