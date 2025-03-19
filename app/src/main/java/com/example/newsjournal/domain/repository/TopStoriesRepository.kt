package com.example.newsjournal.domain.repository

import com.example.newsjournal.domain.models.TopStoriesResponse

interface TopStoriesRepository {

   suspend fun getTopStoriesValue(section:String): TopStoriesResponse?
}