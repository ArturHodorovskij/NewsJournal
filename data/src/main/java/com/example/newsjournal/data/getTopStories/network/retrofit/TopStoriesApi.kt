package com.example.newsjournal.data.getTopStories.network.retrofit

import com.example.newsjournal.data.getTopStories.models.TopStoriesNYT

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TopStoriesApi {
    @GET("{section}.json")
    suspend fun getTopStories(
        @Path("section") section: String,
        @Query("api-key") apiKey: String
    ):  TopStoriesNYT?
}
