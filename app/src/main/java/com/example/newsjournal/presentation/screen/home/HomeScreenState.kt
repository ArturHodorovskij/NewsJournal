package com.example.newsjournal.presentation.screen.home

import com.example.newsjournal.domain.models.TopStories

sealed class HomeScreenState {
    data object Initial : HomeScreenState()
    data object Loading : HomeScreenState()
    data class Content(val items: TopStories) : HomeScreenState()
    data class Error(val errorMessage: String) : HomeScreenState()
}