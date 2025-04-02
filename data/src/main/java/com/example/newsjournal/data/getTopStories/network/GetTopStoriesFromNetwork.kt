package com.example.newsjournal.data.getTopStories.network

import com.example.newsjournal.data.getTopStories.models.TopStoriesNYT
import com.example.newsjournal.data.getTopStories.network.retrofit.TopStoriesApiClient

private const val API_KEY = "obOVPCKM90qO7FX4aUKp4ZcsVYmzBX02"

class GetTopStoriesFromNetwork: TopStoriesNetwork {

    override suspend fun getTopStoriesValue(section: String): TopStoriesNYT? {
        val topStories = TopStoriesApiClient.api.getTopStories(section, API_KEY)
        return topStories
    }
}