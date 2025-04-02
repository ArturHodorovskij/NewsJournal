package com.example.newsjournal.presentation.screen.tagcontent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.getTopStories.network.GetTopStoriesFromNetwork
import com.example.newsjournal.data.getTopStories.repository.TopStoriesRepositoryImpl
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

    var tag: String = "home"

    init {
        loadData(tag)
    }

    private fun loadData(tag: String) {
        _state.value = TagContentScreenState.Loading
        viewModelScope.launch {
            try {
                val getTopStories = getTopStoriesUseCase.execute(tag)
                if (getTopStories != null) {
                    _state.value = TagContentScreenState.Content(getTopStories)
                } else {
                    throw Exception()
                }
            } catch (e: Exception) {
                handleError(e.message.toString())
            }
        }
    }

    fun reloadData(tag: String) {
        loadData(tag)
    }

    private fun handleError(errorMessage: String) {
        _state.value = TagContentScreenState.Error(errorMessage = errorMessage)
    }
}