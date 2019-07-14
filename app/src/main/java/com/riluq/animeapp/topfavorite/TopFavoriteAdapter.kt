package com.riluq.animeapp.topfavorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.riluq.animeapp.databinding.TopFavoriteListItemBinding
import com.riluq.animeapp.network.TopFavorite

class TopFavoriteAdapter: ListAdapter<TopFavorite, TopFavoriteAdapter.TopFavoriteViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopFavoriteViewHolder {
        return TopFavoriteViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TopFavoriteViewHolder, position: Int) {
        val topFavorite = getItem(position)
        holder.bind(topFavorite)
    }


    class TopFavoriteViewHolder(private val binding: TopFavoriteListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(topFavorite: TopFavorite) {
            binding.topFavorite = topFavorite
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TopFavoriteViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    TopFavoriteListItemBinding.inflate(layoutInflater, parent, false)
                return TopFavoriteViewHolder(binding)
            }
        }

    }


    companion object DiffCallBack: DiffUtil.ItemCallback<TopFavorite>() {
        override fun areItemsTheSame(oldItem: TopFavorite, newItem: TopFavorite): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TopFavorite, newItem: TopFavorite): Boolean {
            return oldItem.idTopFavorite == newItem.idTopFavorite
        }

    }
}