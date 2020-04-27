package com.mobileapp.learnkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mobileapp.learnkotlin.codelabs.guesstheword.GuessTheWordActivity
import com.mobileapp.learnkotlin.codelabs.androidtrivia.AndroidTriviaActivity
import com.mobileapp.learnkotlin.codelabs.constraintlayout.ColorMyViewsAppActivity
import com.mobileapp.learnkotlin.codelabs.diceapp.DiceAppActivity
import com.mobileapp.learnkotlin.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {

    lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_launcher)
    }

    fun navigateToNextPage(view: View) {
        val nextPage = when (view.id) {
            R.id.dice_app_launch_button -> Intent(this, DiceAppActivity::class.java)
            R.id.color_my_view_app_launch_button -> Intent(
                this,
                ColorMyViewsAppActivity::class.java
            )
            R.id.trivia_launch_button -> Intent(this, AndroidTriviaActivity::class.java)
            R.id.guess_the_word_launch_button -> Intent(this, GuessTheWordActivity::class.java)
            else -> null
        }
        startActivity(nextPage)
    }
}
