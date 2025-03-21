package com.example.newsjournal.domain.network

import com.example.newsjournal.domain.models.TopStories

interface TopStoriesRepository {

   suspend fun getTopStoriesValue(section:String): TopStories?
}