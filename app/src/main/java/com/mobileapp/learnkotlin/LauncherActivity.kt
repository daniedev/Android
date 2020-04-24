package com.mobileapp.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import codelabs.androidtrivia.AndroidTriviaActivity
import codelabs.constraintlayout.ColorMyViewsAppActivity
import codelabs.diceapp.DiceAppActivity
import com.mobileapp.learnkotlin.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {

    lateinit var binding : ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_launcher)
    }

    fun navigateToNextPage(view: View) {
        val nextPage = when(view.id){
            R.id.dice_app_launch_button -> Intent(this, DiceAppActivity::class.java)
            R.id.color_my_view_app_launch_button -> Intent(this, ColorMyViewsAppActivity::class.java)
            R.id.trivia_launch_button -> Intent(this, AndroidTriviaActivity::class.java)
            else -> null
        }
        startActivity(nextPage)
    }
}
