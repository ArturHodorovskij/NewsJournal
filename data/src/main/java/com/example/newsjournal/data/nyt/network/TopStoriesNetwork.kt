package com.example.newsjournal.data.nyt.network

import com.example.newsjournal.data.nyt.models.TopStoriesResponse

interface TopStoriesNetwork {
    suspend fun getTopStoriesValue(section: String): TopStoriesResponse?
}