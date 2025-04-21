package com.example.newsjournal.domain.usecase

import com.example.newsjournal.domain.models.backandless.NewsDetails
import com.example.newsjournal.domain.network.BackendlessRepository

class GetNewsFromBackendlessUseCase(private val backendlessRepository: BackendlessRepository) {
    suspend fun execute():List<NewsDetails> = backendlessRepository.getNews()
}