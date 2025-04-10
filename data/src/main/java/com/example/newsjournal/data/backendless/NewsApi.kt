package com.example.newsjournal.data.backendless

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {
    @GET("ArticleShort")
    suspend fun loadAllNews(): List<ShortArticle>

    @GET("ArticleShort?loadRelations={relation}")
    suspend fun loadNewsByTag(
        @Path("loadRelations") relation: String = "tags",
        @Query("where") tag: String
    ): List<ShortArticle>
//    suspend fun saveNewsToBookmark()
//    suspend fun loadSavedNews()
//    suspend fun loadNewsDetail()
}