package com.example.newsjournal.data.backendless

class NewsApiImpl : NewsApi {
    override suspend fun loadAllNews(): List<ShortArticle> =
        BackendlessRetrofitClient.api.loadAllNews()

    override suspend fun loadNewsByTag(tag: String, relation: String): List<ShortArticle> =
        BackendlessRetrofitClient.api.loadNewsByTag(tag = tag)
}