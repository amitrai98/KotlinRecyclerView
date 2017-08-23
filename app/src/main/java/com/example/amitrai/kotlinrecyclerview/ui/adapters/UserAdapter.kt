//package com.example.amitrai.kotlinrecyclerview.ui.adapters
//
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.amitrai.kotlinrecyclerview.R
//import com.example.amitrai.kotlinrecyclerview.bean.UserBean
//import kotlinx.android.synthetic.main.user_profile.view.*
//
///**
// * Created by amitrai on 4/8/17.
// * used for :-
// */
//class UserAdapter(val userList: Array<UserBean>) : RecyclerView.Adapter<UserAdapter.CustomViewHolder>(){
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        var item = userList[position]
//
//        if (position>0){
//            holder.txt_name.text = item.login
//            holder.txt_id = item.id as Int
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
//        val layoutInflater = LayoutInflater.from(parent?.context)
//        return CustomViewHolder(layoutInflater.inflate(R.layout.user_profile, parent, false))
//    }
//
//
//    override fun getItemCount(): Int {
//        return userList.size
//    }
//
//    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        val txt_name = view.txt_name
//        var txt_id = view.id
//    }
//}