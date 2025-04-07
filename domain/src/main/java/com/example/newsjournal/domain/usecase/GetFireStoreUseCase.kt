package com.example.newsjournal.domain.usecase

import com.example.newsjournal.domain.models.TopStories
import com.example.newsjournal.domain.network.FireStoreRepository

class GetFireStoreUseCase(private val fireStoreRepository: FireStoreRepository) {

    suspend fun execute(collection: String): TopStories? =
        fireStoreRepository.getNewsValue(collection = collection)

}
