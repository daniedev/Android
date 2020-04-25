package com.mobileapp.learnkotlin.codelabs.androidtrivia.screens


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.mobileapp.learnkotlin.R
import com.mobileapp.learnkotlin.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )
        binding.triviaPlayButton.setOnClickListener { view: View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.trivia_options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item!!,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }


}
