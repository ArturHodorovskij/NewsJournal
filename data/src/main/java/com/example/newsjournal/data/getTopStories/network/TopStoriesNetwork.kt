package com.example.newsjournal.data.getTopStories.network

import com.example.newsjournal.data.getTopStories.models.TopStoriesNYT


interface TopStoriesNetwork {
    suspend fun getTopStoriesValue(section: String): TopStoriesNYT?
}