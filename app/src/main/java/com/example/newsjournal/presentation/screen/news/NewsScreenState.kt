package com.example.newsjournal.presentation.screen.news

import com.example.newsjournal.domain.models.NYT.Article

sealed class NewsScreenState {
    data object Initial : NewsScreenState()
    data object Loading : NewsScreenState()
    data class Content(val items: Article) : NewsScreenState()
    data class Error(val errorMessage: String) : NewsScreenState()
}