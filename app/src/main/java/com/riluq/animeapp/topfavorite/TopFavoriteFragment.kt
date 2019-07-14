package com.riluq.animeapp.topfavorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.riluq.animeapp.R
import com.riluq.animeapp.databinding.FragmentTopFavoriteBinding
import com.riluq.animeapp.topairing.TopAiringAdapter

class TopFavoriteFragment : Fragment() {

    private val viewModel: TopFavoriteViewModel by lazy {
        ViewModelProviders.of(this).get(TopFavoriteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTopFavoriteBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.srlTopFavorite.setColorSchemeResources(R.color.secondaryColor,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)

        binding.rvTopFavorite.adapter = TopFavoriteAdapter()

        binding.srlTopFavorite.setOnRefreshListener {
            viewModel.getTopFavorite()
        }


        return binding.root
    }


}
