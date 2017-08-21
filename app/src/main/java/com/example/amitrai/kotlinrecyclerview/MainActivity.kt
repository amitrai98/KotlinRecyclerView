package com.example.amitrai.kotlinrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.amitrai.kotlinapirequest.bean.BaseBean
import com.example.amitrai.kotlinapirequest.http.request.SimpleRequest
import com.example.amitrai.kotlinapirequest.listeners.ApiCallback
import com.example.amitrai.kotlinrecyclerview.bean.UserBean

class MainActivity : AppCompatActivity(), ApiCallback {



    var request = SimpleRequest()

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init(){
        try {
            request.getGitUsers(1, this)
        }catch (e: Exception){
            e.printStackTrace()
        }


    }

    override fun onRequestSuccess(bean: BaseBean) {
        Log.e(TAG , "success "+bean)
        bean as UserBean

    }

    override fun onRequestFailed(message: String) {
        Log.e(TAG , "request failed "+message)
    }

    override fun onUserSuccess(userBean: Array<UserBean>) {
        Toast.makeText(this, "response success "+ userBean.size,Toast.LENGTH_LONG).show()
    }


}
