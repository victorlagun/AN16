package com.techmeskills.an16.homework04.adapter

import android.content.res.Resources
import android.service.autofill.FillEventHistory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.techmeskills.an16.homework04.convertDurationToFormatted
import com.techmeskills.an16.homework04.convertNumericQualityToString
import com.techmeskills.an16.homework04.database.SleepNight
import com.techmeskills.an16.lagun_victor.homework04.R
import kotlinx.android.synthetic.main.text_item_view.view.*

class SleepNightAdapter:ListAdapter<SleepNight, ListItemSleepViewHolder> (SleepNightDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ListItemSleepViewHolder {
        return ListItemSleepViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListItemSleepViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}