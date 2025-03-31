package com.example.newsjournal.presentation.screen.news

data class NewsScreenState(
    var url: String = "", var isLoading: Boolean = true, var errorMessage: String? = null
)
