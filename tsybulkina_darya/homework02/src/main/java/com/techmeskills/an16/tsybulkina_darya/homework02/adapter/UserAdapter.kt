package com.techmeskills.an16.tsybulkina_darya.homework02.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.techmeskills.an16.tsybulkina_darya.homework02.R
import com.techmeskills.an16.tsybulkina_darya.homework02.model.Person
import kotlinx.android.synthetic.main.item_person.view.*

class UserAdapter(private val persons: List<Person>): RecyclerView.Adapter<UserAdapter.PersonHolder>() {

    class PersonHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val itemList = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false) as ConstraintLayout
        return PersonHolder(itemList)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        if (persons.size ==0){
            holder.layout.textView.text = "Список пуст"
        }else {
            holder.layout.textView.text = persons[position].toString()
        }
    }

    override fun getItemCount() = persons.size

}