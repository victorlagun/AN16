package com.techmeskills.an16.homework04.adapter

import android.content.res.Resources
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
        return ListItemSleepViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListItemSleepViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() =data.size
}