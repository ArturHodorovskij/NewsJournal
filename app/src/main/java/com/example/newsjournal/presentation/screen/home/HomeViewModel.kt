package com.example.newsjournal.presentation.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.backendless.models.BackendlessArticle
import com.example.newsjournal.data.backendless.network.GetAllNews
import com.example.newsjournal.data.backendless.repository.BackendlessRepositoryImpl
import com.example.newsjournal.data.nyt.network.GetTopStoriesFromNetwork
import com.example.newsjournal.data.nyt.repository.TopStoriesRepositoryImpl
import com.example.newsjournal.domain.models.backandless.NewsDetails
import com.example.newsjournal.domain.usecase.GetNewsFromBackendlessUseCase
import com.example.newsjournal.domain.usecase.GetTopStoriesUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    companion object {
        private const val ROOT_NEWS_TAG = "home"
    }

    private var getAllNews = GetAllNews()
    private var backendlessRepository =
        BackendlessRepositoryImpl(getNewsFromBackendless = getAllNews)
    private var getNewsFromBackendlessUseCase =
        GetNewsFromBackendlessUseCase(backendlessRepository = backendlessRepository)


    private var getTopStoriesFromNetwork = GetTopStoriesFromNetwork()
    private var topStoriesRepository =
        TopStoriesRepositoryImpl(topStoriesFromNetwork = getTopStoriesFromNetwork)
    private var getTopStoriesUseCase =
        GetTopStoriesUseCase(topStoriesRepository = topStoriesRepository)


    private val _state = MutableLiveData<HomeScreenState>()
    val state: LiveData<HomeScreenState> = _state

    private val _newState = MutableLiveData<List<NewsDetails>>()
    val newState: LiveData<List<NewsDetails>> = _newState

    init {
//        loadData(ROOT_NEWS_TAG)
        loadData()
    }

    private fun loadData() {
        _state.value = HomeScreenState.Loading
        viewModelScope.launch {
            try {
                val getNews = getNewsFromBackendlessUseCase.execute()
                if (getNews != null) {
                    _state.value = HomeScreenState.Content(getNews)
                } else {
                    throw Exception()
                }
            } catch (e: Exception) {
                handleError(e.message.toString())
            }
        }
    }

    fun reloadData() {
//        loadData(ROOT_NEWS_TAG)
        loadData()
    }

    private fun handleError(errorMessage: String) {
        _state.value = HomeScreenState.Error(errorMessage = errorMessage)
    }
}

