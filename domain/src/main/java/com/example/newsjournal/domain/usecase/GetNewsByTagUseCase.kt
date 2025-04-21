package com.example.newsjournal.domain.usecase

import com.example.newsjournal.domain.models.backandless.NewsDetails
import com.example.newsjournal.domain.network.BackendlessRepository

class GetNewsByTagUseCase(private val backendlessRepository: BackendlessRepository) {
    suspend fun execute(tag: String): List<NewsDetails> =
        backendlessRepository.getNewsByTag(tag = tag)
}