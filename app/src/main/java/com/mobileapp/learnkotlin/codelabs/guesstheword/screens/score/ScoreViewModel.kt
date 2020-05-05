package com.mobileapp.learnkotlin.codelabs.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    private var _score = MutableLiveData<Int>()
    private var _eventPlayAgain = MutableLiveData<Boolean>()
    val score: LiveData<Int>
        get() = _score
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    init {
        _score.value = finalScore
        Log.i("FinalScore", "Final Score is $finalScore")
    }

    fun onClickPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun onEventPlayAgainComplete() {
        _eventPlayAgain.value = false
    }
}