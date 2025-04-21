package com.example.newsjournal.presentation.screen.tagcontent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.backendless.network.GetAllNews
import com.example.newsjournal.data.backendless.repository.BackendlessRepositoryImpl
import com.example.newsjournal.data.nyt.network.GetTopStoriesFromNetwork
import com.example.newsjournal.data.nyt.repository.TopStoriesRepositoryImpl
import com.example.newsjournal.domain.usecase.GetNewsByTagUseCase
import com.example.newsjournal.domain.usecase.GetTopStoriesUseCase
import kotlinx.coroutines.launch


class TagContentViewModel : ViewModel() {

    private var getAllNews = GetAllNews()
    private var backendlessRepository =
        BackendlessRepositoryImpl(getNewsFromBackendless = getAllNews)
    private var getNewsByTagUseCase =
        GetNewsByTagUseCase(backendlessRepository = backendlessRepository)



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
                val getNewsByTag = getNewsByTagUseCase.execute(tag)
                if (getNewsByTag != null) {
                    _state.value = TagContentScreenState.Content(getNewsByTag)
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