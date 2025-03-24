package com.example.newsjournal.presentation.screen.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.network.GetTopStoriesFromNetwork
import com.example.newsjournal.data.repository.TopStoriesRepositoryImpl
import com.example.newsjournal.domain.models.Article
import com.example.newsjournal.domain.models.TopStories
import com.example.newsjournal.domain.usecase.GetTopStoriesUseCase
import kotlinx.coroutines.launch
import kotlin.text.Typography.section


class HomeViewModel : ViewModel() {
    private var getTopStoriesFromNetwork = GetTopStoriesFromNetwork()
    private var topStoriesRepository = TopStoriesRepositoryImpl(topStoriesFromNetwork = getTopStoriesFromNetwork)
    private var getTopStoriesUseCase = GetTopStoriesUseCase(topStoriesRepository = topStoriesRepository)

    private val _state = MutableLiveData<HomeScreenState>()
    val state: LiveData<HomeScreenState> = _state


    fun loadData(section: String) {
        _state.value = HomeScreenState.Loading
        viewModelScope.launch {
            try {
                _state.value  =  HomeScreenState.Content(getTopStoriesUseCase.execute(section))
            } catch (e: Exception) {
                handleError(e.message.toString())
            }
        }
    }

    private fun handleError(errorMessage: String) {
        _state.value = HomeScreenState.Error(errorMessage = errorMessage)
    }
}

