package com.example.newsjournal.data.repository


import com.example.newsjournal.data.network.TopStoriesNetwork
import com.example.newsjournal.domain.models.TopStoriesResponse
import com.example.newsjournal.domain.network.TopStoriesRepository

class TopStoriesRepositoryImpl(private val topStoriesFromNetwork: TopStoriesNetwork) : TopStoriesRepository {

    override suspend fun getTopStoriesValue(section: String): TopStoriesResponse? {
        val topStoriesValue = topStoriesFromNetwork.getTopStoriesValue(section)

        val topStoriesResponse = topStoriesValue?.let { TopStoriesResponse(results = it.results ) }

        return topStoriesResponse
    }
}