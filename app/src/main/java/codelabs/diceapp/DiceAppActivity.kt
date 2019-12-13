package codelabs.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.ActivityDiceAppBinding
import kotlin.random.Random

class DiceAppActivity : AppCompatActivity() {

    lateinit var numberToBeDisplayed: ImageView
    lateinit var binding: ActivityDiceAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dice_app)
        numberToBeDisplayed = binding.numberToBeDisplayed
        binding.rollButton.setOnClickListener{rollDice()}
    }

    private fun rollDice() {
        Toast.makeText(this, "dice rolled", Toast.LENGTH_SHORT).show()
        val drawableResource = when (generateRandomNumber()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        numberToBeDisplayed.setImageResource(drawableResource)
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(6) + 1
    }

}
