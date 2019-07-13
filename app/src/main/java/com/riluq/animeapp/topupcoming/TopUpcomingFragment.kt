package com.riluq.animeapp.topupcoming


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.riluq.animeapp.R
import com.riluq.animeapp.databinding.FragmentTopAiringBinding
import com.riluq.animeapp.databinding.FragmentTopUpcomingBinding
import com.riluq.animeapp.topairing.TopAiringAdapter
import com.riluq.animeapp.topairing.TopAiringViewModel


class TopUpcomingFragment : Fragment() {

    private val viewModel: TopUpcomingViewModel by lazy {
        ViewModelProviders.of(this).get(TopUpcomingViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTopUpcomingBinding.inflate(inflater)
        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        binding.viewModel = viewModel

        binding.srlTopUpcoming.setColorSchemeResources(R.color.secondaryColor,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)

        binding.rvTopUpcoming.adapter = TopUpcomingAdapter()

        binding.srlTopUpcoming.setOnRefreshListener {
            viewModel.getTopUpcoming()
        }

        return binding.root
    }


}
