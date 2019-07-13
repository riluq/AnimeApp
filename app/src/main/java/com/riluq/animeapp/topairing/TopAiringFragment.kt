package com.riluq.animeapp.topairing


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.riluq.animeapp.R
import com.riluq.animeapp.databinding.FragmentTopAiringBinding


class TopAiringFragment : Fragment() {

    private val viewModel: TopAiringViewModel by lazy {
        ViewModelProviders.of(this).get(TopAiringViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTopAiringBinding.inflate(inflater)
        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        binding.viewModel = viewModel

        binding.srlTopAiring.setColorSchemeResources(R.color.secondaryColor,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)

        binding.rvTopAiring.adapter = TopAiringAdapter()

        binding.srlTopAiring.setOnRefreshListener {
            viewModel.getTopAiring()
        }

        return binding.root
    }

}
