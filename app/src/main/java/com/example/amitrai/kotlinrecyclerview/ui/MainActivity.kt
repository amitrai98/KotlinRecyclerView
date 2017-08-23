package com.example.amitrai.kotlinrecyclerview.ui

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.amitrai.kotlinapirequest.bean.BaseBean
import com.example.amitrai.kotlinapirequest.http.request.SimpleRequest
import com.example.amitrai.kotlinapirequest.listeners.ApiCallback
import com.example.amitrai.kotlinrecyclerview.R
import com.example.amitrai.kotlinrecyclerview.bean.UserBean
import com.example.amitrai.kotlinrecyclerview.ui.adapters.UsersAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ApiCallback {

    lateinit var userAdapter: UsersAdapter


    lateinit var userList: Array<UserBean>

    lateinit var pd:  ProgressDialog


    var request = SimpleRequest()

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init() = try {
        pd = ProgressDialog(this)
        pd.setMessage("Please Wait")
        pd.show()
        request.getGitUsers(1, this)
    }catch (e: Exception){
        e.printStackTrace()
    }

    override fun onRequestSuccess(bean: BaseBean) {
        Log.e(TAG , "success "+bean)
        if (pd.isShowing)
            pd.dismiss()


    }

    override fun onRequestFailed(message: String) {
        Log.e(TAG , "request failed "+message)
        if (pd.isShowing)
            pd.dismiss()
    }

    override fun onUserSuccess(userBean: Array<UserBean>) {
        if (pd.isShowing)
            pd.dismiss()
        userList = userBean


        userList = arrayOf(UserBean())
        userAdapter = UsersAdapter(userBean, this)
        recycler_view.adapter = userAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        userAdapter.notifyDataSetChanged()

        Toast.makeText(this, "response success "+ userBean.size,Toast.LENGTH_LONG).show()
    }


}
