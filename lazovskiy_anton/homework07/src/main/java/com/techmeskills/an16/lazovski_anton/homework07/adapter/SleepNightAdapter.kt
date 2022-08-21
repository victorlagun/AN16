package com.techmeskills.an16.lazovski_anton.homework04.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.database.SleepNight
import com.techmeskills.an16.lazovski_anton.homework04.R
import kotlinx.android.synthetic.main.text_item_view.view.*

class SleepNightAdapter: RecyclerView.Adapter<ListItemSleepNightViewHolder>(){
    var data = listOf<SleepNight>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemSleepNightViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return ListItemSleepNightViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemSleepNightViewHolder, position: Int) {
        val res = holder.itemView.context.resources
        val item = data[position]
        holder.sleepLength.text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
    }

    override fun getItemCount() = data.size


}