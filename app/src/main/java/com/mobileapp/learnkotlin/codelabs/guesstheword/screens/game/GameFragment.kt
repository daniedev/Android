package com.mobileapp.learnkotlin.codelabs.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    private lateinit var binding: GameFragmentBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding.skipButton.setOnClickListener { onSkip() }
        binding.correctButton.setOnClickListener { onCorrect() }
        binding.endGameButton.setOnClickListener { endGame() }
        updateWordText()
        updateScoreText()
        return binding.root
    }

    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
        updateWordText()
        updateScoreText()
    }

    private fun endGame() {
        Toast.makeText(activity, "Game has ended!!!", Toast.LENGTH_LONG).show()
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score
        findNavController().navigate(action)
    }

    private fun updateWordText() {
        binding.wordText.text = viewModel.word
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }
}
