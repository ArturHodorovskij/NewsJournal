package com.example.newsjournal.domain.models

data class Article(
    val title: String,
    val abstract: String,
    val multimedia: List<Multimedia>?,
    val url: String,
    val byline: String,
    val publishedDate: String?
)