package com.example.newsjournal.domain.models

data class Article(
    val title: String,
    val abstract: String,
    val multimedia: List<Multimedia>?,
)