package com.example.newsjournal.presentation.screen.tagcontent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.network.GetTopStoriesFromNetwork
import com.example.newsjournal.data.repository.TopStoriesRepositoryImpl
import com.example.newsjournal.domain.usecase.GetTopStoriesUseCase
import kotlinx.coroutines.launch


class TagContentViewModel : ViewModel() {
    private var getTopStoriesFromNetwork = GetTopStoriesFromNetwork()
    private var topStoriesRepository =
        TopStoriesRepositoryImpl(topStoriesFromNetwork = getTopStoriesFromNetwork)
    private var getTopStoriesUseCase =
        GetTopStoriesUseCase(topStoriesRepository = topStoriesRepository)

    private val _state = MutableLiveData<TagContentScreenState>()
    val state: LiveData<TagContentScreenState> = _state

    fun loadData(tag: String) {
        _state.value = TagContentScreenState.Loading
        viewModelScope.launch {
            try {
                _state.value = TagContentScreenState.Content(getTopStoriesUseCase.execute(tag))
            } catch (e: Exception) {
                handleError(e.message.toString())
            }
        }
    }

    private fun handleError(errorMessage: String) {
        _state.value = TagContentScreenState.Error(errorMessage = errorMessage)
    }
}
