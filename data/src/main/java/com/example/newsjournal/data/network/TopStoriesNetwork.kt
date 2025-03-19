package com.example.newsjournal.data.network

import com.example.newsjournal.data.models.Response


interface TopStoriesNetwork {
    suspend fun getTopStoriesValue(section: String): Response?
}