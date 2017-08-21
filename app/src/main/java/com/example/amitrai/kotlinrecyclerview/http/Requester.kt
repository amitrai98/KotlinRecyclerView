package com.example.amitrai.kotlinapirequest.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */
class Requester {


    internal fun provideRetrofit(): Retrofit {
        val BASE_URL =  "http://192.168.1.91"

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}