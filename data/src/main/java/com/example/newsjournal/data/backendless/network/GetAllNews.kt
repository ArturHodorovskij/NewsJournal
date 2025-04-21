package com.example.newsjournal.data.backendless.network

import com.example.newsjournal.data.backendless.models.BackendlessArticle
import com.example.newsjournal.data.backendless.network.retrofit.BackendlessRetrofitClient


class GetAllNews : NewsBackendless {

    override suspend fun getNews(): List<BackendlessArticle> =
        BackendlessRetrofitClient.api.loadAllNews()

    override suspend fun getNewsByTag(tag: String): List<BackendlessArticle> {
        val whereClause = "tags LIKE'%$tag%'"
       val news =  BackendlessRetrofitClient.api.loadNewsByTag(whereClause)
        return news
    }

}
