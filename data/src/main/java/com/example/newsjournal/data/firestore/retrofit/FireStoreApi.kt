package com.example.newsjournal.data.firestore.retrofit

import com.example.newsjournal.data.firestore.models.TopStoriesFireStore
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FireStoreApi {

    @GET("projects/{projectId}/databases/{databaseId}/documents/{collectionId}")
    suspend fun getItems(
        @Path("projectId") projectId: String,
        @Path("databaseId") databaseId: String,
        @Path("collectionId") collectionId: String
    ): TopStoriesFireStore?

    @POST("projects/{projectId}/databases/{databaseId}/documents/{collectionId}")
    suspend fun addItem(
        @Path("projectId") projectId: String,
        @Path("databaseId") databaseId: String,
        @Path("collectionId") collectionId: String,
        @Body item: TopStoriesFireStore?
    )

    @DELETE("projects/{projectId}/databases/{databaseId}/documents/{documentPath}")
    suspend fun deleteItem(
        @Path("projectId") projectId: String,
        @Path("databaseId") databaseId: String,
        @Path("documentPath") documentPath: String
    )
}
