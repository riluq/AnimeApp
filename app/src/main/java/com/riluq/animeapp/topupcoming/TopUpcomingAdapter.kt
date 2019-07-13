package com.riluq.animeapp.topupcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.riluq.animeapp.databinding.TopUpcomingListItemBinding
import com.riluq.animeapp.network.TopUpcoming

class TopUpcomingAdapter: ListAdapter<TopUpcoming, TopUpcomingAdapter.TopUpcomingViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopUpcomingViewHolder {
        return TopUpcomingViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TopUpcomingViewHolder, position: Int) {
        val topAiring = getItem(position)
        holder.bind(topAiring)
    }

    class TopUpcomingViewHolder(private val binding: TopUpcomingListItemBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(topUpcoming: TopUpcoming) {
            binding.topUpcoming = topUpcoming
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TopUpcomingViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TopUpcomingListItemBinding.inflate(layoutInflater, parent, false)
                return TopUpcomingViewHolder(binding)
            }
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<TopUpcoming>() {
        override fun areItemsTheSame(oldItem: TopUpcoming, newItem: TopUpcoming): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TopUpcoming, newItem: TopUpcoming): Boolean {
            return oldItem.idTopUpcoming == newItem.idTopUpcoming
        }

    }
}