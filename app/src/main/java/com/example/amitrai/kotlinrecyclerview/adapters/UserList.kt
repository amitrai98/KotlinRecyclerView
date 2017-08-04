package com.example.amitrai.kotlinrecyclerview.adapters

import com.example.amitrai.kotlinrecyclerview.bean.UserBean

/**
 * Created by amitrai on 4/8/17.
 * used for :-
 */

class UserList(val userList: List<UserBean>) {

    val size: Int
        get() = userList.size

    operator fun get(position: Int) = userList[position]
}