package com.example.newsjournal.domain.models.backandless

data class NewsDetails(
    val isFavourite: Boolean,
    val content: String,
    val description: String,
    val imageUrl: String,
    val publishDate: String,
    val tags: String,
    val title: String
)
