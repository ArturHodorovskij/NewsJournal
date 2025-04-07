package com.example.newsjournal.data.firestore.network

import com.example.newsjournal.data.firestore.models.TopStoriesFireStore

interface NewsFireStore {
    suspend fun getNewsFromFireStore(collection:String): TopStoriesFireStore?
}