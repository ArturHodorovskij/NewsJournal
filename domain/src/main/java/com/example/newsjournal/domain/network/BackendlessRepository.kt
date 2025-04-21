package com.example.newsjournal.domain.network

import com.example.newsjournal.domain.models.backandless.NewsDetails

interface BackendlessRepository {
    suspend fun getNews(): List<NewsDetails>
}