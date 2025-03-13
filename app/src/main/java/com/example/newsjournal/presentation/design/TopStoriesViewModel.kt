package com.example.newsjournal.presentation.design

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.retrofit.topStoriesApi.RetrofitInstance
import com.example.newsjournal.domain.TopStoriesResponse
import kotlinx.coroutines.launch

const val API_KEY = "obOVPCKM90qO7FX4aUKp4ZcsVYmzBX02"
var section = "home"

class TopStoriesViewModel : ViewModel() {
    private val _topStoriesResponse = MutableLiveData <TopStoriesResponse>()
    val topStoriesResponse: LiveData<TopStoriesResponse>  = _topStoriesResponse
    fun load(){
        viewModelScope.launch {
            _topStoriesResponse.value = RetrofitInstance.api.getTopStories(section, API_KEY)
        }
    }
}


