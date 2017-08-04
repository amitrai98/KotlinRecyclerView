package com.example.amitrai.kotlinapirequest.http.request

import com.example.amitrai.kotlinapirequest.http.ApiBuilder
import com.example.amitrai.kotlinapirequest.http.ApiInterface
import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */
open class BaseRequest {

    var DATA = "data"
    var MESSAGE = "message"
    var STATUS = "status"

    /**
     * provides api client for making requests
     * @return Builder instance for making requests.
     */
    val apiClient: ApiInterface
        get() = ApiBuilder().createApiBuilder()

    /**
     * Provides GSON builder for casting response.
     * @return Gson.
     */
    val gsonBuilder: Gson
        get() {
            val gson = GsonBuilder().create()
            gson.serializeNulls()
            return gson
        }
}
