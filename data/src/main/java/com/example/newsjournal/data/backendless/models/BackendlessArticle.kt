package com.example.newsjournal.data.backendless.models

data class BackendlessArticle(
    val isFavourite: Boolean,
    val content: String,
    val description: String,
    val imageUrl: String,
    val publishDate: String,
    val tags: String,
    val title: String
)
