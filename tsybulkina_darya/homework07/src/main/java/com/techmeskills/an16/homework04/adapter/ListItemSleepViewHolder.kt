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
        val res = itemView.context.resources
        binding.sleepLength.text =
            convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
        binding.qualityString.text = convertNumericQualityToString(item.sleepQuality, res)
        binding.qualityImage.setImageResource(
            when (item.sleepQuality) {
                0 -> R.drawable.ic_sleep_0
                1 -> R.drawable.ic_sleep_1
                2 -> R.drawable.ic_sleep_2
                3 -> R.drawable.ic_sleep_3
                4 -> R.drawable.ic_sleep_4
                5 -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_launcher_sleep_tracker_foreground
            }
        )
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