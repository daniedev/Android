package com.mobileapp.learnkotlin.codelabs.guesstheword

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobileapp.learnkotlin.R

/**
 * Creates an Activity that hosts all of the fragments in the app
 */
class GuessTheWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_the_word)
    }

}
