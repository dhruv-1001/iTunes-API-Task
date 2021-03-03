package com.devdhruv.myapplication.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://itunes.apple.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface iTunesApiService{
    @GET("artistDetails")
    fun getProperties():
            Call<String>
}

object iTunesApi{
    val retrofitService: iTunesApiService by lazy {
        retrofit.create(iTunesApiService::class.java)
    }
}