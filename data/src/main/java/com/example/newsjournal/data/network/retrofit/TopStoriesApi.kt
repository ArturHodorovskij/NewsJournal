package com.example.newsjournal.data.network.retrofit

import com.example.newsjournal.data.models.TopStoriesResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TopStoriesApi {
    @GET("{section}.json")
    suspend fun getTopStories(
        @Path("section") section: String,
        @Query("api-key") apiKey: String
    ): TopStoriesResponse?
}
