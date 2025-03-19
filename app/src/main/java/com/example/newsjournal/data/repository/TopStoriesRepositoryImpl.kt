package com.example.newsjournal.data.repository

import com.example.newsjournal.data.network.RetrofitInstance
import com.example.newsjournal.domain.models.TopStoriesResponse
import com.example.newsjournal.domain.repository.TopStoriesRepository

const val API_KEY = "obOVPCKM90qO7FX4aUKp4ZcsVYmzBX02"

class TopStoriesRepositoryImpl : TopStoriesRepository {
    override suspend fun getTopStoriesValue(section: String): TopStoriesResponse? {
        val topStoriesValue = RetrofitInstance.api.getTopStories(section, API_KEY)
        return topStoriesValue
    }
}