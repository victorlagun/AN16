package com.techmeskills.an16.homework04.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.techmeskills.an16.homework04.database.SleepNight
import com.techmeskills.an16.homework04.sleeptracker.SleepNightListener

class SleepNightAdapter(val clickListener: SleepNightListener):ListAdapter<SleepNight, ListItemSleepViewHolder> (SleepNightDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ListItemSleepViewHolder {
        return ListItemSleepViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListItemSleepViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
}