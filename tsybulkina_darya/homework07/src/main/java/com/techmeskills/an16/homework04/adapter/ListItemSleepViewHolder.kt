package com.techmeskills.an16.homework04.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techmeskills.an16.homework04.convertDurationToFormatted
import com.techmeskills.an16.homework04.convertNumericQualityToString
import com.techmeskills.an16.homework04.database.SleepNight
import com.techmeskills.an16.lagun_victor.homework04.R
import com.techmeskills.an16.lagun_victor.homework04.databinding.ListItemSleepNightBinding

class ListItemSleepViewHolder private constructor(val binding: ListItemSleepNightBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SleepNight) {
        binding.sleep = item
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ListItemSleepViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding =
                ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
            return ListItemSleepViewHolder(binding)
        }
    }
}