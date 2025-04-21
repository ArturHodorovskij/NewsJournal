package com.example.newsjournal.data.backendless.repository

import com.example.newsjournal.data.backendless.network.NewsBackendless
import com.example.newsjournal.domain.models.backandless.NewsDetails
import com.example.newsjournal.domain.network.BackendlessRepository

class BackendlessRepositoryImpl(private val getNewsFromBackendless: NewsBackendless) :
    BackendlessRepository {
    override suspend fun getNews(): List<NewsDetails> {
        val news = getNewsFromBackendless.getNews()
        return news.map {
            NewsDetails(
                isFavourite = it.isFavourite,
                content = it.content,
                description = it.description,
                imageUrl = it.imageUrl,
                publishDate = it.publishDate,
                tags = it.tags,
                title = it.title
            )
        }
    }
}