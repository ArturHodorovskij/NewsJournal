package com.example.newsjournal.data.backendless.network.retrofit

import com.example.newsjournal.data.backendless.models.BackendlessArticle
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {
    @GET("ArticleDetail?pageSize=100")
    suspend fun loadAllNews(): List<BackendlessArticle>

    @GET("ArticleDetail?loadRelations={relation}")
    suspend fun loadNewsByTag(
        @Path("loadRelations") relation: String = "tags",
        @Query("where") tag: String
    ): List<BackendlessArticle>
//    suspend fun saveNewsToBookmark()
//    suspend fun loadSavedNews()
//    suspend fun loadNewsDetail()
}