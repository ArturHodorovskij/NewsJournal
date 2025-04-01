package com.example.newsjournal.presentation.screen.news

import com.example.newsjournal.domain.models.TopStories

sealed class NewsScreenState {
    data object Initial : NewsScreenState()
    data object Loading : NewsScreenState()
    data class Content(val items: TopStories) : NewsScreenState()
    data class Error(val errorMessage: String) : NewsScreenState()
}