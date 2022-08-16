package com.techmeskills.an16.bondarenko_vadim.homework05.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techmeskills.an16.bondarenko_vadim.homework05.R
import com.techmeskills.an16.bondarenko_vadim.homework05.TextItemViewHolder


import com.techmeskills.an16.bondarenko_vadim.homework05.database.SleepNight

class SleepNightAdapter : RecyclerView.Adapter<TextItemViewHolder>() {
    var data = listOf<SleepNight>()
    set(value){
        field = value
        notifyDataSetChanged()
    }
    override fun getItemCount() =
        data.size


    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.sleepQuality.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}