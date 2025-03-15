package com.example.newsjournal.presentation.tagcontent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.network.retrofit.topStoriesApi.RetrofitInstance
import com.example.newsjournal.domain.TopStoriesResponse
import kotlinx.coroutines.launch

const val API_KEY = "obOVPCKM90qO7FX4aUKp4ZcsVYmzBX02"


class TagContentViewModel() : ViewModel() {
    private val _topStoriesResponse = MutableLiveData<TopStoriesResponse>()
    val topStoriesResponse: LiveData<TopStoriesResponse> = _topStoriesResponse //это че такое

    fun load(section:String = "") {
        viewModelScope.launch {
            _topStoriesResponse.value = RetrofitInstance.api.getTopStories(section, API_KEY)
        }
    }
}