package com.example.amitrai.kotlinapirequest.listeners


import com.example.amitrai.kotlinapirequest.bean.BaseBean
import com.example.amitrai.kotlinrecyclerview.bean.UserBean

/**
 * Created by amit rai on 20/3/17.
 * callbacks for api
 */

interface ApiCallback {
    fun onRequestSuccess(bean: BaseBean)
    fun onRequestFailed(message: String)
    fun onUserSuccess( userBean : Array<UserBean>)
}
