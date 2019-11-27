package com.mobileapp.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import codelabs.diceapp.DiceAppActivity

class LauncherActivity : AppCompatActivity() {

    lateinit var diceApp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        diceApp = findViewById(R.id.dice_app_button)
    }

    fun navigateToDiceAppActivity(view: View) {
        val changePage = Intent(this, DiceAppActivity::class.java)
        startActivity(changePage)
    }
}
