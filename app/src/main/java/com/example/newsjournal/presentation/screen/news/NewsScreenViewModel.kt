package com.example.newsjournal.presentation.screen.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(NewsScreenState())
    val state: StateFlow<NewsScreenState> = _state

    fun loadUrl(url: String) {
        _state.value = NewsScreenState(isLoading = true)

        viewModelScope.launch {
            delay(3000)
            try {
                _state.value = NewsScreenState(url = url, isLoading = false)
            } catch (e: Exception) {
                _state.value = NewsScreenState(
                    url = url,
                    isLoading = false,
                    errorMessage = e.message.toString()
                )
            }
        }
    }
}

