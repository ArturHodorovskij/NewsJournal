package com.example.newsjournal.data.firestore.models

data class TopStoriesFireStore(
    val results: List<ArticleFireStore> = listOf(),
    val copyright: String=""
)
