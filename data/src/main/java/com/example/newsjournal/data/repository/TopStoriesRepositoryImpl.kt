package com.example.newsjournal.data.repository

import com.example.newsjournal.data.network.TopStoriesNetwork
import com.example.newsjournal.domain.models.TopStories
import com.example.newsjournal.domain.network.TopStoriesRepository

class TopStoriesRepositoryImpl(private val topStoriesFromNetwork: TopStoriesNetwork) : TopStoriesRepository {

    override suspend fun getTopStoriesValue(section: String): TopStories? {
        val topStoriesValue = topStoriesFromNetwork.getTopStoriesValue(section)
        return topStoriesValue?.let { TopStories(results = it.results, copyright = it.copyright) }
    }
}