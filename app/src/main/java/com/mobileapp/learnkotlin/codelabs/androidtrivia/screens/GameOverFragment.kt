package com.mobileapp.learnkotlin.codelabs.androidtrivia.screens


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.FragmentGameOverAndroidTriviaBinding

/**
 * A simple [Fragment] subclass.
 */
class GameOverFragment : Fragment() {

    lateinit var binding : FragmentGameOverAndroidTriviaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game_over_android_trivia,container,false)
        binding.tryAgainButton.setOnClickListener { view: View -> view.findNavController().navigate(
            GameOverFragmentDirections.actionGameOverFragmentToGameFragment()
        ) }
        return binding.root
    }





}
