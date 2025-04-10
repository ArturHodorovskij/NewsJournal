package com.example.newsjournal.data.backendless

data class ShortArticle(
    val id: String,
    val title: String,
    val description: String,
    val tags: String,
    val image_url: String,
    val articleDetailId: String,
    val isSaveToUser: Boolean,
)
