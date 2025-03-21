package com.example.newsjournal.data.network

import com.example.newsjournal.data.models.TopStoriesResponse


interface TopStoriesNetwork {
    suspend fun getTopStoriesValue(section: String): TopStoriesResponse?
}