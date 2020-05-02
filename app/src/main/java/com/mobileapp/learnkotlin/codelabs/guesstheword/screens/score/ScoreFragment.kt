package com.mobileapp.learnkotlin.codelabs.guesstheword.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.FragmentScoreGuessTheWordBinding


/**
 * Fragment where the final score is shown, after the game is over
 */
class ScoreFragment : Fragment() {

    private lateinit var viewModelFactory: ScoreViewModelFactory
    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: FragmentScoreGuessTheWordBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_score_guess_the_word,
            container,
            false
        )
        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).score)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScoreViewModel::class.java)
        binding.scoreText.text = viewModel.score.toString()
        return binding.root
    }
}
