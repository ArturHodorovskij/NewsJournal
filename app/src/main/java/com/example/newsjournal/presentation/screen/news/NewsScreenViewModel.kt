package com.example.newsjournal.presentation.screen.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.domain.models.NYT.Article
import com.example.newsjournal.domain.models.backandless.NewsDetails
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class NewsScreenViewModel : ViewModel() {

    private val _state = MutableLiveData<NewsScreenState>()
    val state: LiveData<NewsScreenState> = _state

    fun loadNews(items: NewsDetails) {
        _state.value = NewsScreenState.Loading
        viewModelScope.launch {
            delay(1000)
            try {
                _state.value = NewsScreenState.Content(items)
            } catch (e: Exception) {
                handleError(e.message.toString())
            }
        }
    }

    private fun handleError(errorMessage: String) {
        _state.value = NewsScreenState.Error(errorMessage = errorMessage)
    }
}