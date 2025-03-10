package com.example.newsjournal.data.retrofit.topStoriesApi

suspend fun exampleUsage() {
    val repository = TopStoriesRepository()
    val topStories = repository.getTopStories( "arts") // Example: fetching "arts" section
    if (topStories != null) {
        println("Successfully fetched ${topStories.num_results} articles from ${topStories.section}")
        topStories.results.forEach { article ->
            println("Title: ${article.title}")
        }
    } else {
        println("Failed to fetch top stories.")
    }
}

//че дальше?)