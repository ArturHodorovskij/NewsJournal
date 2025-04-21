package com.example.newsjournal.presentation.screen.news

import com.example.newsjournal.domain.models.NYT.Article
import com.example.newsjournal.domain.models.backandless.NewsDetails

sealed class NewsScreenState {
    data object Initial : NewsScreenState()
    data object Loading : NewsScreenState()
    data class Content(val items: NewsDetails) : NewsScreenState()
    data class Error(val errorMessage: String) : NewsScreenState()
}