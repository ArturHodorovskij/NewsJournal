package com.example.newsjournal.presentation.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.backendless.NewsApiImpl
import com.example.newsjournal.data.backendless.ShortArticle
import com.example.newsjournal.data.network.GetTopStoriesFromNetwork
import com.example.newsjournal.data.repository.TopStoriesRepositoryImpl
import com.example.newsjournal.domain.usecase.GetTopStoriesUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    companion object {
        private const val ROOT_NEWS_TAG = "home"
    }

    private var getTopStoriesFromNetwork = GetTopStoriesFromNetwork()
    private var topStoriesRepository =
        TopStoriesRepositoryImpl(topStoriesFromNetwork = getTopStoriesFromNetwork)
    private var getTopStoriesUseCase =
        GetTopStoriesUseCase(topStoriesRepository = topStoriesRepository)


    private val _state = MutableLiveData<HomeScreenState>()
    val state: LiveData<HomeScreenState> = _state

    private val _newState = MutableLiveData<List<ShortArticle>>()
    val newState: LiveData<List<ShortArticle>> = _newState

    init {
//        loadData(ROOT_NEWS_TAG)
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val data = NewsApiImpl().loadNewsByTag(
                tag = "%60tags%60.%60tag%60%20%3D%20'arts'",
                relation = "tags"
            )
            _newState.value = data
        }
    }

//    private fun loadData(section: String) {
//        _state.value = HomeScreenState.Loading
//        viewModelScope.launch {
//            try {
//                val getTopStories = getTopStoriesUseCase.execute(section)
//                if (getTopStories != null) {
//                    _state.value = HomeScreenState.Content(getTopStories)
//                } else {
//                    throw Exception()
//                }
//            } catch (e: Exception) {
//                handleError(e.message.toString())
//            }
//        }
//    }

    fun reloadData() {
//        loadData(ROOT_NEWS_TAG)
    }

    private fun handleError(errorMessage: String) {
        _state.value = HomeScreenState.Error(errorMessage = errorMessage)
    }
}

