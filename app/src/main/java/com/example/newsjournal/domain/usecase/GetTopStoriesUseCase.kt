package com.example.newsjournal.domain.usecase

import com.example.newsjournal.domain.models.TopStoriesResponse
import com.example.newsjournal.domain.repository.TopStoriesRepository

class GetTopStoriesUseCase(private val topStoriesRepository: TopStoriesRepository) {

    suspend fun execute(section:String):TopStoriesResponse?{
        val topStoriesValue = topStoriesRepository.getTopStoriesValue(section = section)
        return topStoriesValue
    }
}