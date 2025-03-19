package com.example.newsjournal.data.network

import com.example.newsjournal.data.models.Response
import com.example.newsjournal.data.network.retrofit.RetrofitInstance

private const val API_KEY = "obOVPCKM90qO7FX4aUKp4ZcsVYmzBX02"

class GetTopStoriesFromNetwork: TopStoriesNetwork {

    override suspend fun getTopStoriesValue(section: String): Response? {
        val topStories = RetrofitInstance.api.getTopStories(section, API_KEY)
        return topStories
    }
}