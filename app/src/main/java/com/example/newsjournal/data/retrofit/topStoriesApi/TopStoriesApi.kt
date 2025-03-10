package com.example.newsjournal.data.retrofit.topStoriesApi

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TopStoriesApi {
    @GET("{section}.json")
    fun getTopStories(
        @Path("section") section: String,   // Параметр для раздела (например, "arts")
        @Query("api-key") apiKey: String    // Параметр для API-ключа
    ): TopStoriesResponse?      // Возвращаем тип данных, с которым будем работать
}
