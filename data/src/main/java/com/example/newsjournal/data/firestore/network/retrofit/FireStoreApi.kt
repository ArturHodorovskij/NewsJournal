package com.example.newsjournal.data.firestore.network.retrofit

import com.example.newsjournal.data.firestore.models.FirestoreResponse
import com.example.newsjournal.data.firestore.models.TopStoriesFireStore
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FireStoreApi {

    @GET("projects/{projectId}/databases/(default)/documents/{collectionId}")
    suspend fun getNews(
        @Path("projectId") projectId: String,
        @Path("collectionId") collectionId: String,
    ): FirestoreResponse?

    @POST("projects/{projectId}/databases/(default)/documents/{collectionId}/{documentId}")
    suspend fun postNews(
        @Path("projectId") projectId: String,
        @Path("collectionId") collectionId: String,
        @Body item: FirestoreResponse
    )

    @DELETE("projects/{projectId}/databases/(default)/documents/{documentPath}")
    suspend fun deleteNews(
        @Path("projectId") projectId: String,
        @Path("documentPath") documentPath: String
    )
}
