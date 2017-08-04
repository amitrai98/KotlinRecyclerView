package com.example.amitrai.kotlinapirequest.http


import android.util.Log
import com.example.amitrai.kotlinapirequest.listeners.BaseListener


import org.json.JSONObject

import java.io.IOException

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */

class ConnectionManager {
    private var enqueueCall: Call<ResponseBody>? = null

    private val TAG = javaClass.simpleName

    /**
     * que an api call
     * @param mCall to be que up
     */
    private fun setEnqueueCall(mCall: Call<ResponseBody>) {

        this.enqueueCall = mCall
    }


    /**
     * make call to api
     * @param mListener to convey api response to the requester
     */
    fun callApi(mListener: BaseListener.OnWebServiceCompleteListener) {
        this.enqueueCall!!.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.isSuccessful) {
                    mListener.onWebServiceComplete(response.body())
                } else {
                    try {
                        val error = response.errorBody().string()
                        val `object` = JSONObject(error)

                        var message = ""
                        if (`object`.has("Message"))
                            message = `object`.getString("Message")
                        Log.e(TAG, "error message " + message)
                        mListener.onWebStatusFalse(message)

                    } catch (exp: Exception) {
                        exp.printStackTrace()
                        mListener.onWebStatusFalse("Oops! An Error Occurred")
                    }

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                if (t is IOException) {
                    mListener.onWebStatusFalse(ConnectionManager.STR_NO_CONNECTION)
                    return
                }
                mListener.onWebStatusFalse(""+t.message)
            }
        })
    }

    companion object {
        private val STR_NO_CONNECTION = "Trouble reaching server, no internet connection."
        private var mConnectionManger: ConnectionManager? = null

        fun getConnectionInstance(call: Call<ResponseBody>): ConnectionManager {
            if (mConnectionManger == null) {
                mConnectionManger = ConnectionManager()
                mConnectionManger!!.setEnqueueCall(call)
                return mConnectionManger as ConnectionManager
            } else {
                mConnectionManger!!.setEnqueueCall(call)
                return mConnectionManger as ConnectionManager
            }
        }
    }
}
