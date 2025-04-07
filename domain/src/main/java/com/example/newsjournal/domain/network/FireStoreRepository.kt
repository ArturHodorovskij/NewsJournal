package com.example.newsjournal.domain.network

import com.example.newsjournal.domain.models.TopStories

interface FireStoreRepository {
    suspend fun getNewsValue(collection:String): TopStories?
}