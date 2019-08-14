package com.riluq.animeapp.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.riluq.animeapp.databinding.ScheduleListItemBinding
import com.riluq.animeapp.network.Schedule

class ScheduleAdapter: ListAdapter<Schedule, ScheduleAdapter.ScheduleViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = getItem(position)
        holder.bind(schedule)
    }

    class ScheduleViewHolder(private val binding: ScheduleListItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(schedule: Schedule) {
            binding.schedule = schedule
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ScheduleViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ScheduleListItemBinding.inflate(layoutInflater, parent, false)
                return ScheduleViewHolder(binding)
            }
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Schedule>() {
        override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
            return oldItem.idSchedule == newItem.idSchedule
        }
    }
}