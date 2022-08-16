package com.techmeskills.an16.staroselets_elena.homework02


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class MyListAdapter(private var ctx: Context, private val users: MutableList<User>)
    : ArrayAdapter<User>(ctx, R.layout.listview_item, users) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        //val inflater = context.get ctx.layoutInflater
       // val rowView = inflater.inflate(R.layout.listview_item, null, true)

        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.listview_item, parent, false)

        val userText = rowView.findViewById(R.id.label) as TextView


        userText.text = users[position].toString()


        return rowView
    }
}