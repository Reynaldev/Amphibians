package com.reyndev.amphibians.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.reyndev.amphibians.databinding.FragmentAmphibianListBinding

class AmphibianListFragment : Fragment() {
    private val viewModel: AmphibianViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAmphibianListBinding.inflate(inflater)

        // TODO: call the view model method that calls the amphibians api

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = AmphibianListAdapter(AmphibianListener { amphibian ->
            viewModel.onAmphibianClicked(amphibian)

            val action = AmphibianListFragmentDirections.actionAmphibianListFragmentToAmphibianDetailFragment(
                amphibian.name.toString()
            )

            findNavController().navigate(action)
        })

        return binding.root
    }
}