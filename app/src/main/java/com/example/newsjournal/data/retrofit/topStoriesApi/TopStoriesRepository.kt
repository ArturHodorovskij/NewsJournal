package com.example.newsjournal.data.retrofit.topStoriesApi

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.text.Typography.section

const val API_KEY = "obOVPCKM90qO7FX4aUKp4ZcsVYmzBX02"

class TopStoriesRepository{
    private val apiService = RetrofitInstance.api
    suspend fun getTopStories(section: String): TopStoriesResponse? {
        return withContext(Dispatchers.IO)
        {
                val response = apiService.getTopStories(section, API_KEY)
                response

        }
    }
}

class TopStoriesViewModel : ViewModel() {
    private val userRepository = TopStoriesRepository()
    val storiesResponse = listOf(liveData(Dispatchers.IO) {
        try {
            val topStoriesResponse = userRepository.getTopStories("home")
            emit(topStoriesResponse) // Отправляем данные в UI
        } catch (exception: Exception) {
             // В случае ошибки отправляем пустой список
        }
    })
}


