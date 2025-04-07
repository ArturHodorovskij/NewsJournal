package com.example.newsjournal.presentation.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.firestore.repository.FireStoreRepositoryImpl
import com.example.newsjournal.data.firestore.network.GetNewsFromFireStore
import com.example.newsjournal.domain.usecase.GetFireStoreUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    private var getNewsFromFireStore = GetNewsFromFireStore()
    private var fireStoreRepository = FireStoreRepositoryImpl(newsFireStore = getNewsFromFireStore)
    private var getFireStoreUseCase = GetFireStoreUseCase(fireStoreRepository = fireStoreRepository)

    private val _state = MutableLiveData<HomeScreenState>()
    val state: LiveData<HomeScreenState> = _state

    companion object {
        private const val ROOT_COLLECTION = "News2"
    }

    init {
        loadNews(ROOT_COLLECTION)
    }


    private fun loadNews(collection: String) {
        _state.value = HomeScreenState.Loading
        viewModelScope.launch {
            try {
                val getNews = getFireStoreUseCase.execute(collection)
                if (getNews != null) {
                    _state.value = HomeScreenState.Content(getNews)
                } else {
                    throw Exception()
                }
            }  catch (e: Exception) {
                handleError(e.message.toString())
            }
        }
    }

    private fun handleError(errorMessage: String) {
        _state.value = HomeScreenState.Error(errorMessage = errorMessage)
    }
    fun reloadData(){
        loadNews(ROOT_COLLECTION)
    }

}



///////////////////////////////////////////////////////////////////

//    companion object {
//        private const val ROOT_NEWS_TAG = "home"
//    }
//
//    private var getTopStoriesFromNetwork = GetTopStoriesFromNetwork()
//    private var topStoriesRepository =
//        TopStoriesRepositoryImpl(topStoriesFromNetwork = getTopStoriesFromNetwork)
//    private var getTopStoriesUseCase =
//        GetTopStoriesUseCase(topStoriesRepository = topStoriesRepository)
//
//    private val _state = MutableLiveData<HomeScreenState>()
//    val state: LiveData<HomeScreenState> = _state
//
//    init {
//        loadData(ROOT_NEWS_TAG)
//
//    }
//
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
//
//    fun reloadData() {
//        loadData(ROOT_NEWS_TAG)
//    }
//
//    private fun handleError(errorMessage: String) {
//        _state.value = HomeScreenState.Error(errorMessage = errorMessage)
//    }
//}

