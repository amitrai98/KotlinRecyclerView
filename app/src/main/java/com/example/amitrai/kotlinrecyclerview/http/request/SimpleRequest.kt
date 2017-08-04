package com.example.amitrai.kotlinapirequest.http.request

import android.util.Log


import com.example.amitrai.kotlinapirequest.http.ConnectionManager
import com.example.amitrai.kotlinapirequest.listeners.ApiCallback
import com.example.amitrai.kotlinapirequest.listeners.BaseListener

import org.json.JSONObject

import okhttp3.ResponseBody
import retrofit2.Call

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
                Log.e(TAG, "" + baseObject)
                try {
                    val jsonObject = JSONObject(baseObject.string())

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
