package com.example.newsjournal.presentation.screen.tagcontent

import com.example.newsjournal.domain.models.TopStories

sealed class TagContentScreenState {
    data object Initial : TagContentScreenState()
    data object Loading : TagContentScreenState()
    data class Content(val items: TopStories?) : TagContentScreenState()
    data class Error(val errorMessage: String) : TagContentScreenState()
}
