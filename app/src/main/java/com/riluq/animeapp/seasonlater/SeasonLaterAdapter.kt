package com.riluq.animeapp.seasonlater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.riluq.animeapp.databinding.SeasonLaterListItemBinding
import com.riluq.animeapp.network.SeasonLater

class SeasonLaterAdapter: ListAdapter<SeasonLater, SeasonLaterAdapter.SeasonLaterViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonLaterViewHolder {
        return SeasonLaterViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SeasonLaterViewHolder, position: Int) {
        val seasonLater = getItem(position)
        holder.bind(seasonLater)
    }


    class SeasonLaterViewHolder(private val binding: SeasonLaterListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(seasonLater: SeasonLater) {
            binding.seasonLater = seasonLater
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): SeasonLaterViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SeasonLaterListItemBinding.inflate(layoutInflater, parent, false)
                return SeasonLaterViewHolder(binding)
            }
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<SeasonLater>() {
        override fun areItemsTheSame(oldItem: SeasonLater, newItem: SeasonLater): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SeasonLater, newItem: SeasonLater): Boolean {
            return oldItem.idSeasonLater == newItem.idSeasonLater
        }

    }
}