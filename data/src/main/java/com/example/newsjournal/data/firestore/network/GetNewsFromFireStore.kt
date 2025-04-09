package com.example.newsjournal.data.firestore.network

import com.example.newsjournal.data.firestore.models.FirestoreResponse
import com.example.newsjournal.data.firestore.models.TopStoriesFireStore
import com.example.newsjournal.data.firestore.network.retrofit.FireStoreApiClient

private const val PROJECT_ID = "newsjournal-7fdf0"
private const val DOCUMENT_ID = "qs4mYLZQl5PhETUSUrZu"

class GetNewsFromFireStore: NewsFireStore {
    override suspend fun getNewsFromFireStore(collection:String): FirestoreResponse?{
        val getNews = FireStoreApiClient.api.getNews(PROJECT_ID, collection)
        return getNews
    }
}