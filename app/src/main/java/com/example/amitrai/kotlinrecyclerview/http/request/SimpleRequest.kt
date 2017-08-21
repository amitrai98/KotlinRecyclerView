package com.example.amitrai.kotlinapirequest.http.request

import android.util.Log


import com.example.amitrai.kotlinapirequest.http.ConnectionManager
import com.example.amitrai.kotlinapirequest.listeners.ApiCallback
import com.example.amitrai.kotlinapirequest.listeners.BaseListener
import com.example.amitrai.kotlinrecyclerview.bean.UserBean
import com.example.amitrai.kotlinrecyclerview.bean.UserBeanResponse

import org.json.JSONObject

import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import junit.framework.TestCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder



/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */

class SimpleRequest : BaseRequest() {

    private val TAG = javaClass.simpleName

    /**
     * try to login user on server with the username and password provided
     */
    fun getGitUsers(since : Int, callback: ApiCallback) {
        val callSaveRoute = apiClient.getGitUsers(since)
        val connectionManager = ConnectionManager.getConnectionInstance(callSaveRoute)
        connectionManager.callApi(object : BaseListener.OnWebServiceCompleteListener {
            override fun onWebServiceComplete(baseObject: ResponseBody) {
                try {
//                    val jsonObj = JSONObject(baseObject.string().substring(baseObject.string().indexOf("{"), baseObject.string().lastIndexOf("}") + 1))
                    val jsonObject = JSONArray(baseObject.string())
                    Log.e("git response ", " "+jsonObject.toString())

                    val gsonBuilder = GsonBuilder()
                    val gson = gsonBuilder.create()

                    val testCase = gson.fromJson(jsonObject.toString(), Array<UserBean>::class.java)


//                    val routeModal = gsonBuilder.fromJson(jsonObject.toString(), UserBeanResponse::class.java)
                    callback.onUserSuccess(testCase)
                } catch (exp: Exception) {
                    exp.printStackTrace()
                    callback.onRequestFailed("Error occurred while parsing")
                }

            }

            override fun onWebStatusFalse(message: String) {
                callback.onRequestFailed(message)
            }
        })
    }
}
