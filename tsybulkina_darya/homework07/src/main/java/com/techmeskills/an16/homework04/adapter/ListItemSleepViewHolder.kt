package com.techmeskills.an16.homework04.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techmeskills.an16.lagun_victor.homework04.R

class ListItemSleepViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
    val quality: TextView = itemView.findViewById(R.id.quality_string)
    val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)
}