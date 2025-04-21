package com.example.newsjournal.domain.models.NYT

data class Article(
    val title: String,
    val abstract: String,
    val multimedia: List<Multimedia>?,
    val url: String,
    val byline: String?,
    val publishedDate: String?,
    val updatedDate: String?,
    val createdDate: String?
)