package com.example.temen_food_waste.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.temen_food_waste.R
import com.example.temen_food_waste.data.entity.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var username: TextView
        var email: TextView
        var password: TextView
        var id_user: TextView
        var is_email_verified: TextView

        init {
            username = view.findViewById(R.id.username)
            email = view.findViewById(R.id.email)
            password = view.findViewById(R.id.password)
            id_user = view.findViewById(R.id.id_user)
            is_email_verified = view.findViewById(R.id.is_email_verified)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.username.text = list[position].username
        holder.email.text = list[position].email
        holder.password.text = list[position].password
        holder.id_user.text = list[position].id_user.toString()
        holder.is_email_verified.text = list[position].is_email_verified.toString()

    }
}