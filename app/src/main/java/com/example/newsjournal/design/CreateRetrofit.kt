package com.example.newsjournal.design

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun createRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder().build() // Инициализация Moshi
    val client = OkHttpClient.Builder().build()  // Инициализация клиента OkHttp (для обработки запросов)

    return Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/svc/topstories/v2/")  // Базовый URL API
        .client(client)  // Клиент OkHttp
        .addConverterFactory(GsonConverterFactory.create()) .build()   // Указываем Moshi для конвертации JSON  // Строим экземпляр Retrofit

}



fun fetchTopStories(apiKey: String, section: String) {
    val retrofit = createRetrofit()  // Получаем экземпляр Retrofit
    val api = retrofit.create(TopStoriesApi::class.java)  // Создаем объект API

    val call = api.getTopStories(section, apiKey)  // Выполняем запрос

    call.enqueue(object : Callback<TopStoriesResponse> {  // Асинхронная обработка запроса
        override fun onResponse(
            call: Call<TopStoriesResponse>,
            response: Response<TopStoriesResponse>
        ) {
            if (response.isSuccessful) {
                val topStories = response.body()  // Получаем тело ответа
                topStories?.results?.forEach { article ->  // Перебираем статьи
                    println("Title: ${article.title}")  // Выводим заголовок статьи
                    println("Abstract: ${article.abstract}")  // Выводим аннотацию
                    println("URL: ${article.url}")  // Выводим URL
                    println("---")
                }
            } else {
                println("Error: ${response.code()}")  // Обрабатываем ошибку
            }
        }

        override fun onFailure(call: Call<TopStoriesResponse>, t: Throwable) {
            println("Failed to fetch data: ${t.message}")  // Обработка ошибки при запросе
        }
    })
}

fun main() {
    val apiKey = "your-api-key"  // Указываем свой API-ключ
    val section = "arts"  // Например, раздел "arts"

    fetchTopStories(apiKey, section)  // Вызываем функцию для получения топовых статей
}