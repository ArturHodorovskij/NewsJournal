package com.example.newsjournal.data.retrofit.topStoriesApi

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "obOVPCKM90qO7FX4aUKp4ZcsVYmzBX02"

fun createRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder()// Инициализация Gson
    val client = OkHttpClient.Builder()
        .build()  // Инициализация клиента OkHttp (для обработки запросов)

    return retrofit
        .baseUrl("https://api.nytimes.com/svc/topstories/v2/")  // Базовый URL API
        .client(client)  // Клиент OkHttp
        .addConverterFactory(GsonConverterFactory.create())// Указываем Gson для конвертации JSON
        .build()     // Строим экземпляр Retrofit

}


fun getTopStories( section: String) {
    val retrofit = createRetrofit()  // Получаем экземпляр Retrofit
    val api = retrofit.create(TopStoriesApi::class.java)  // Создаем объект API

    val call = api.getTopStories(section, API_KEY)  // Выполняем запрос

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
                    println("URL: ${article.uri}")
                    println("---")  //TODO рефакторинг через корутины!

                    article.multimedia?.forEach { multimedia ->
                        println("Multimedia Type: ${multimedia.type}")
                        println("Subtype: ${multimedia.subtype}")
                        println("Caption: ${multimedia.caption}")
                        println("URL: ${multimedia.url}")
                        println("Format: ${multimedia.format}")
                        println("Height: ${multimedia.height}")
                        println("Width: ${multimedia.width}")
                        println("Copyright: ${multimedia.copyright}")
                        println("------")
                    }
                }

            } else {
                println("Error: ${response.code()}")  // Обрабатываем ошибку---- ЭТО ЧТО ТАКОЕ?
            }
        }

        override fun onFailure(call: Call<TopStoriesResponse>, t: Throwable) {
            println("Failed to fetch data: ${t.message}")  // Обработка ошибки при запросе-ЧЕМ ЭТО ОТЛИЧАЕТСЯ?
        }
    })
}


