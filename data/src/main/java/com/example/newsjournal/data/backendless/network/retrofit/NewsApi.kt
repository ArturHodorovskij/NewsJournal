package com.example.newsjournal.data.backendless.network.retrofit

import com.example.newsjournal.data.backendless.models.BackendlessArticle
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("ArticleDetail")
    suspend fun loadAllNews(
        @Query("pageSize") pageSize: Int = 100
    ): List<BackendlessArticle>

    @GET("ArticleDetail")
    suspend fun loadNewsByTag(
        @Query("where") whereClause: String,
        @Query("pageSize") pageSize: Int=100

        ): List<BackendlessArticle>
//    suspend fun saveNewsToBookmark()
//    suspend fun loadSavedNews()
//    suspend fun loadNewsDetail()
}