package codelabs.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobileapp.learnkotlin.R
import kotlin.random.Random

class DiceAppActivity : AppCompatActivity() {

    lateinit var numberToBeDisplayed: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_app)

        val button: Button = findViewById(R.id.roll_button)
        numberToBeDisplayed = findViewById(R.id.number_to_be_displayed)
        button.setOnClickListener { rollDice() }
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
