package com.example.newsjournal.presentation.tagcontent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsjournal.data.repository.TopStoriesRepositoryImpl
import com.example.newsjournal.domain.models.TopStoriesResponse
import com.example.newsjournal.domain.usecase.GetTopStoriesUseCase
import kotlinx.coroutines.launch


class TagContentViewModel : ViewModel() {
    private var topStoriesRepository = TopStoriesRepositoryImpl()
    private var getTopStoriesUseCase =
        GetTopStoriesUseCase(topStoriesRepository = topStoriesRepository)

    private val _topStoriesResponse = MutableLiveData<TopStoriesResponse>()
    val topStoriesResponse: LiveData<TopStoriesResponse> = _topStoriesResponse

    fun load(section: String) {
        viewModelScope.launch {
            _topStoriesResponse.value = getTopStoriesUseCase.execute(section = section)
        }
    }
}