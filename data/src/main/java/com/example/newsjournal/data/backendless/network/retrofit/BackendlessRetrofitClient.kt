package com.example.newsjournal.data.backendless.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BackendlessRetrofitClient {
    private const val BASE_URL = "https://api.backendless.com/5528BCE7-79F1-4E3E-9203-F4D3E4470642/3B39F838-F153-452E-AAF8-63DE1FB860DB/data/"
    private val retrofit: Retrofit by lazy {
        val client = OkHttpClient.Builder().build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api: NewsApi by lazy { retrofit.create(NewsApi::class.java) }
}