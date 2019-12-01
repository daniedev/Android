package codelabs.constraintlayout

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mobileapp.learnkotlin.R
import kotlinx.android.synthetic.main.activity_color_my_views_app.*

class ColorMyViewsAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_my_views_app)
        setListener()
    }

    private fun setListener() {
        val boxOne = findViewById<TextView>(R.id.color_my_view_box_1)
        val boxTwo = findViewById<TextView>(R.id.color_my_view_box_2)
        val boxThree = findViewById<TextView>(R.id.color_my_view_box_3)
        val boxFour = findViewById<TextView>(R.id.color_my_view_box_4)
        val boxFive = findViewById<TextView>(R.id.color_my_view_box_5)
        val appLayout = findViewById<View>(R.id.color_my_app_layout)
        val redButton = findViewById<View>(R.id.color_my_view_red_button)
        val yellowButton = findViewById<View>(R.id.color_my_view_yellow_button)
        val greenButton = findViewById<View>(R.id.color_my_view_green_button)

        val clickableViews: List<View> =
            listOf(
                boxOne,
                boxTwo,
                boxThree,
                boxFour,
                boxFive,
                appLayout,
                redButton,
                yellowButton,
                greenButton
            )

        for (item in clickableViews)
            item.setOnClickListener { makeColored(it) }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.color_my_view_box_1 -> view.setBackgroundColor(Color.GREEN)
            R.id.color_my_view_box_2 -> view.setBackgroundColor(Color.RED)
            R.id.color_my_view_box_3 -> view.setBackgroundColor(Color.BLUE)
            R.id.color_my_view_box_4 -> view.setBackgroundColor(Color.YELLOW)
            R.id.color_my_view_box_5 -> view.setBackgroundColor(Color.MAGENTA)
            R.id.color_my_view_red_button -> color_my_view_box_3.setBackgroundResource(R.color.my_red)
            R.id.color_my_view_yellow_button -> color_my_view_box_4.setBackgroundResource(R.color.my_yellow)
            R.id.color_my_view_green_button -> color_my_view_box_5.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
