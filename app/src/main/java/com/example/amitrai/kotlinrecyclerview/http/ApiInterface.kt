package com.example.amitrai.kotlinapirequest.http


import okhttp3.ResponseBody
import retrofit2.Call
import android.support.annotation.NonNull
import retrofit2.http.*


/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */

interface ApiInterface {

    @FormUrlEncoded
    @GET("/users?since={id}")
    fun getGitUsers(@Path("id") since: Int): Call<ResponseBody>

}
