package com.riluq.animeapp.seasonlater


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.riluq.animeapp.R
import com.riluq.animeapp.databinding.FragmentSeasonLaterBinding
import com.riluq.animeapp.topupcoming.TopUpcomingAdapter

class SeasonLaterFragment : Fragment() {

    private val viewModel: SeasonLaterViewModel by lazy {
        ViewModelProviders.of(this).get(SeasonLaterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSeasonLaterBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.srlSeasonLater.setColorSchemeResources(R.color.secondaryColor,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)

        binding.rvSeasonLater.adapter = SeasonLaterAdapter()

        binding.srlSeasonLater.setOnRefreshListener {
            viewModel.getSeasonLater()
        }

        return binding.root
    }


}
