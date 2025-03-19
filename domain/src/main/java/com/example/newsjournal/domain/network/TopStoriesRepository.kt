package com.example.newsjournal.domain.network

import com.example.newsjournal.domain.models.TopStoriesResponse

interface TopStoriesRepository {

   suspend fun getTopStoriesValue(section:String): TopStoriesResponse?
}