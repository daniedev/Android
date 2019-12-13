package codelabs.androidtrivia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.ActivityAndroidTriviaBinding

class AndroidTriviaActivity : AppCompatActivity() {

    lateinit var binding: ActivityAndroidTriviaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_android_trivia)
    }

}
