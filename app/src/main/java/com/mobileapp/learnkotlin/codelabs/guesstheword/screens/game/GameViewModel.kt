package com.mobileapp.learnkotlin.codelabs.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var _word = MutableLiveData<String>()
    private var _score = MutableLiveData<Int>()
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val word: LiveData<String>
        get() = _word
    val score: LiveData<Int>
        get() = _score
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish
    private lateinit var wordList: MutableList<String>

    init {
        _word.value = ""
        _score.value = 0
        Log.i("GameViewModel", "GameViewModel Created!!")
        resetList()
        nextWord()
    }

    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    fun onSkip() {
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (_score.value)?.plus(1)
        nextWord()
    }

    fun onEndGame() {
        _eventGameFinish.value = true
    }

    fun onEndGameComplete() {
        _eventGameFinish.value = false
    }

    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            _word.value = wordList.removeAt(0)
        }
        else
            _eventGameFinish.value = true
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel Destroyed")
    }
}
