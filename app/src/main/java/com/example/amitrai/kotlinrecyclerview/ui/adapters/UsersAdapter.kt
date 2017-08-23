package com.example.amitrai.kotlinrecyclerview.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.amitrai.kotlinrecyclerview.bean.UserBean
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.amitrai.kotlinrecyclerview.R
import org.w3c.dom.Text


/**
 * Created by amitrai on 22/8/17.
 * used for :-
 */

class UsersAdapter(userBean: Array<UserBean>, app_context: Context) : RecyclerView.Adapter<UsersAdapter.ViewHolder>(){

    val userList = userBean
    val context: Context = app_context

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.user_profile,
                parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItems(userList[position], context)
    }


    //the class is hodling the list view
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bindItems(user: UserBean, context: Context) {
            val textViewName = itemView.findViewById<TextView>(R.id.txt_name) as TextView
            val txt_id  = itemView.findViewById<TextView>(R.id.txt_id) as TextView
            val img_profile  = itemView.findViewById<ImageView>(R.id.img_profile) as ImageView
            textViewName.text = user.login
            txt_id.text = user.type


            Glide.with(context).load(user.avatarUrl).into(img_profile)
        }
    }
}
