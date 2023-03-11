package com.egmvdev.posts.core

import com.egmvdev.posts.model.APIInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return  Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            //.client(obtenerCliente())
            .build()
    }
    fun obtenerCliente(): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(APIInterceptor())
        .build()
}