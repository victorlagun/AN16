package com.techmeskills.an16.eliseyev_aleksandr.homework02.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.techmeskills.an16.eliseyev_aleksandr.homework02.R
import com.techmeskills.an16.eliseyev_aleksandr.homework02.model.Users
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(private val users: List<Users>): RecyclerView.Adapter<UsersAdapter.UserHolder>() {

    class UserHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val itemList = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false) as ConstraintLayout
        return UserHolder(itemList)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        if (users.isEmpty()){
            holder.layout.textView.text = "List is clear"
        } else {
            holder.layout.textView.text = users[position].toString()
        }
    }

    override fun getItemCount() = users.size

}