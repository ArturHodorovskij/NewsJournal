package com.example.newsjournal.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.RetrofitInstance
import com.example.newsjournal.domain.models.TopStoriesResponse
import kotlinx.coroutines.launch

const val API_KEY = "obOVPCKM90qO7FX4aUKp4ZcsVYmzBX02"
var section = "home"

class HomeViewModel : ViewModel() {
    private val _topStoriesResponse = MutableLiveData <TopStoriesResponse>()
    val topStoriesResponse: LiveData<TopStoriesResponse>  = _topStoriesResponse

    fun load(){
        viewModelScope.launch {
            _topStoriesResponse.value = RetrofitInstance.api.getTopStories(section, API_KEY)
        }
    }
}

//я должен сделать отдельный класс который реализует весь этот код, засунуть его в папку data, а замем его передать сюда?
//к примеру сделаем класс
// class GetTopStories (){
//     private val _topStoriesResponse = MutableLiveData <TopStoriesResponse>()
//    val topStoriesResponse: LiveData<TopStoriesResponse>  = _topStoriesResponse
//
//    fun load(){
//        viewModelScope.launch {
//            _topStoriesResponse.value = RetrofitInstance.api.getTopStories(section, API_KEY)
//        }
//    }
//}


// а уже тут class HomeViewModel : ViewModel() {GetTopStories().load}