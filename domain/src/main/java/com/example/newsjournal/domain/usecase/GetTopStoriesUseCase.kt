package com.example.newsjournal.domain.usecase

import com.example.newsjournal.domain.models.TopStories
import com.example.newsjournal.domain.network.TopStoriesRepository

class GetTopStoriesUseCase(private val topStoriesRepository: TopStoriesRepository) {

    suspend fun execute(section: String): TopStories? =
        topStoriesRepository.getTopStoriesValue(section = section)
}
