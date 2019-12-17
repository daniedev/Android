package codelabs.constraintlayout

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.ActivityColorMyViewsAppBinding
import kotlinx.android.synthetic.main.activity_color_my_views_app.*

class ColorMyViewsAppActivity : AppCompatActivity() {

    lateinit var binding: ActivityColorMyViewsAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_color_my_views_app)
        setListener()
    }

    private fun setListener() {
        val boxOne = binding.colorMyViewBox1
        val boxTwo = binding.colorMyViewBox2
        val boxThree = binding.colorMyViewBox3
        val boxFour = binding.colorMyViewBox4
        val boxFive = binding.colorMyViewBox5
        val appLayout = binding.colorMyAppLayout
        val redButton = binding.colorMyViewRedButton
        val yellowButton = binding.colorMyViewYellowButton
        val greenButton = binding.colorMyViewGreenButton

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
