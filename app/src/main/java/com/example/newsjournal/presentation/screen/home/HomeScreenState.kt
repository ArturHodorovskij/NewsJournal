package com.example.newsjournal.presentation.screen.home

import com.example.newsjournal.domain.models.backandless.NewsDetails

sealed class HomeScreenState {
    data object Initial : HomeScreenState()
    data object Loading : HomeScreenState()
    data class Content(val items: List<NewsDetails>) : HomeScreenState()
    data class Error(val errorMessage: String) : HomeScreenState()
}