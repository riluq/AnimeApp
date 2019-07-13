package com.riluq.animeapp.topairing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.riluq.animeapp.databinding.TopAiringListItemBinding
import com.riluq.animeapp.network.TopAiring

class TopAiringAdapter: ListAdapter<TopAiring, TopAiringAdapter.TopAiringViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAiringViewHolder {
        return TopAiringViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TopAiringViewHolder, position: Int) {
        val topAiring = getItem(position)
        holder.bind(topAiring)
    }

    class TopAiringViewHolder(private val binding: TopAiringListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(topAiring: TopAiring) {
            binding.topAiring = topAiring
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): TopAiringViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val bindng = TopAiringListItemBinding.inflate(layoutInflater, parent, false)
                return TopAiringViewHolder(bindng)
            }
        }
    }
    companion object DiffCallback: DiffUtil.ItemCallback<TopAiring>() {
        override fun areItemsTheSame(oldItem: TopAiring, newItem: TopAiring): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TopAiring, newItem: TopAiring): Boolean {
            return oldItem.idTopAiring == newItem.idTopAiring
        }

    }
}