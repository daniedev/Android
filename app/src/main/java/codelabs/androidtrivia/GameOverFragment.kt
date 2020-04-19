package codelabs.androidtrivia


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.FragmentGameOverBinding
import com.mobileapp.learnkotlin.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class GameOverFragment : Fragment() {

    lateinit var binding : FragmentGameOverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater,R.layout.fragment_game_over,container,false)
        binding.tryAgainButton.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment) }
        return binding.root
    }





}
