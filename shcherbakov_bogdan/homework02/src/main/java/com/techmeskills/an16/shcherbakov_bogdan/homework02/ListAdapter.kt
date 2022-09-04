package com.techmeskills.an16.shcherbakov_bogdan.homework02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person.view.*

class ListAdapter(private val data: List<Person>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class UserViewHolder(layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.person, parent, false) as ConstraintLayout
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.textView.text = data[position].toString()
    }

    override fun getItemCount() = data.size
}