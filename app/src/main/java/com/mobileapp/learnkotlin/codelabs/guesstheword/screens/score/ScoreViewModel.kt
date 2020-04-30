package com.mobileapp.learnkotlin.codelabs.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    val score = finalScore
    init {
        Log.i("FinalScore", "Final Score is $finalScore")
    }
}