package com.example.newsjournal.data.firestore.models

data class ArticleFireStore(
    val title: String,
    val abstract: String,
    val multimedia: List<MultimediaFireStore>?,
    val url: String,
    val byline: String?,
    val publishedDate: String?,
    val updatedDate: String?,
    val createdDate: String?
)