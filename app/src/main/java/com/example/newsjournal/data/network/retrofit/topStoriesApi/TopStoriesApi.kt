package com.example.newsjournal.data.network.retrofit.topStoriesApi

import com.example.newsjournal.domain.TopStoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TopStoriesApi {
    @GET("{section}.json")
    suspend fun getTopStories( // почему суспенд? работало ж и без него
        @Path("section") section: String,
        @Query("api-key") apiKey: String
    ): TopStoriesResponse?
}
