package com.example.newsjournal.data.firestore.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FireStoreApiClient {
    private const val BASE_URL = "https://firestore.googleapis.com/v1/"
    private val retrofit: Retrofit by lazy {
        val client = OkHttpClient.Builder().build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    val api: FireStoreApi by lazy { retrofit.create(FireStoreApi::class.java) }
}