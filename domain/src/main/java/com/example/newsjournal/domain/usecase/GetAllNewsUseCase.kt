package com.example.newsjournal.domain.usecase

import com.example.newsjournal.domain.models.backandless.NewsDetails
import com.example.newsjournal.domain.network.BackendlessRepository

class GetAllNewsUseCase(private val backendlessRepository: BackendlessRepository) {
    suspend fun execute():List<NewsDetails> = backendlessRepository.getNews()
}