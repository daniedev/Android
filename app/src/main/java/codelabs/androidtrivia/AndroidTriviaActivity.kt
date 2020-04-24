package codelabs.androidtrivia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.ActivityAndroidTriviaBinding

class AndroidTriviaActivity : AppCompatActivity() {

    lateinit var binding: ActivityAndroidTriviaBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_android_trivia)
        navController = this.findNavController(R.id.triva_nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
