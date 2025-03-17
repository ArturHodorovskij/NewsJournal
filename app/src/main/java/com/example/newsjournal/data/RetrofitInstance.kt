package com.example.newsjournal.data

import com.example.newsjournal.domain.TopStoriesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.nytimes.com/svc/topstories/v2/"
    private val retrofit: Retrofit by lazy { // че это
        val client = OkHttpClient.Builder().build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    val api: TopStoriesApi by lazy {
        retrofit.create(TopStoriesApi::class.java)
    }
}