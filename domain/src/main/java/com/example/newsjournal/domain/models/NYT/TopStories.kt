package com.example.newsjournal.domain.models.NYT

data class TopStories(
    val results: List<Article>,
    val copyright: String
)
