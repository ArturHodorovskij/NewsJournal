package com.example.newsjournal.domain.network

import com.example.newsjournal.domain.models.TopStoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetTopStoriesFromApi {
    @GET("{section}.json")
    suspend fun getTopStories(
        @Path("section") section: String,
        @Query("api-key") apiKey: String
    ): TopStoriesResponse?
}
