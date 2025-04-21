package com.example.newsjournal.data.backendless.network

import com.example.newsjournal.data.backendless.models.BackendlessArticle

interface NewsBackendless {
    suspend fun getNews():List<BackendlessArticle>

    suspend fun getNewsByTag(tag:String):List<BackendlessArticle>

}