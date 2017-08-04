package com.example.amitrai.kotlinapirequest.listeners


import okhttp3.ResponseBody

/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */
interface BaseListener {

    interface OnWebServiceCompleteListener {

        fun onWebServiceComplete(baseObject: ResponseBody)

        // this method will fired when service status is false
        fun onWebStatusFalse(message: String)
    }
}