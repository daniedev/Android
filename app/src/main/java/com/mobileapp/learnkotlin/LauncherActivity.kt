package com.mobileapp.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import codelabs.constraintlayout.ColorMyViewsAppActivity
import codelabs.diceapp.DiceAppActivity
import com.mobileapp.learnkotlin.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {

    lateinit var diceApp : Button
    lateinit var colorMyViewApp : Button
    lateinit var binding : ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_launcher)
        diceApp = binding.diceAppLaunchButton
        colorMyViewApp = binding.colorMyViewAppLaunchButton
    }

    fun navigateToNextPage(view: View) {
        val nextPage = when(view.id){
            R.id.dice_app_launch_button -> Intent(this, DiceAppActivity::class.java)
            R.id.color_my_view_app_launch_button -> Intent(this, ColorMyViewsAppActivity::class.java)
            else -> null
        }
        startActivity(nextPage)
    }
}
