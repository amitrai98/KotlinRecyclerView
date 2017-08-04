package com.example.amitrai.kotlinrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.amitrai.kotlinapirequest.bean.BaseBean
import com.example.amitrai.kotlinapirequest.http.request.SimpleRequest
import com.example.amitrai.kotlinapirequest.listeners.ApiCallback

class MainActivity : AppCompatActivity(), ApiCallback {


    var request = SimpleRequest()

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init(){
        request.getGitUsers(1, this)

    }

    override fun onRequestSuccess(bean: BaseBean) {
        Log.e(TAG , ""+bean)
    }

    override fun onRequestFailed(message: String) {
        Log.e(TAG , message)
    }
}
