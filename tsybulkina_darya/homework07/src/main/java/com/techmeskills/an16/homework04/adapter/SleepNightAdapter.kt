package com.techmeskills.an16.homework04.adapter

import android.service.autofill.FillEventHistory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techmeskills.an16.homework04.convertDurationToFormatted
import com.techmeskills.an16.homework04.convertNumericQualityToString
import com.techmeskills.an16.homework04.database.SleepNight
import com.techmeskills.an16.lagun_victor.homework04.R
import kotlinx.android.synthetic.main.text_item_view.view.*

class SleepNightAdapter:RecyclerView.Adapter<ListItemSleepViewHolder> (){
    var data = listOf<SleepNight>()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ListItemSleepViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_sleep_night,parent, false)
        return ListItemSleepViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemSleepViewHolder, position: Int) {
        val res = holder.itemView.context.resources
        val item = data[position]
        holder.sleepLength.text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
        holder.quality.text= convertNumericQualityToString(item.sleepQuality, res)
        holder.qualityImage.setImageResource(when (item.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_launcher_sleep_tracker_foreground
        })
    }

    override fun getItemCount() =data.size
}