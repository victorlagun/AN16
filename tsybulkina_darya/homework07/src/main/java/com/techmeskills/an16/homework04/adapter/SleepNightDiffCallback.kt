package com.techmeskills.an16.homework04.adapter

import androidx.recyclerview.widget.DiffUtil
import com.techmeskills.an16.homework04.database.SleepNight

class SleepNightDiffCallback:DiffUtil.ItemCallback<SleepNight>() {
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }
}