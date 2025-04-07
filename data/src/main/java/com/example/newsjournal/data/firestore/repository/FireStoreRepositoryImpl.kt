package com.example.newsjournal.data.firestore.repository

import com.example.newsjournal.data.firestore.network.NewsFireStore
import com.example.newsjournal.domain.models.Article
import com.example.newsjournal.domain.models.Multimedia
import com.example.newsjournal.domain.models.TopStories
import com.example.newsjournal.domain.network.FireStoreRepository

class FireStoreRepositoryImpl(private val newsFireStore: NewsFireStore) : FireStoreRepository {
    override suspend fun getNewsValue(collection: String): TopStories? {
        val newsValue = newsFireStore.getNewsFromFireStore(collection)
        return newsValue?.let {
            TopStories(results = it.results.map { items ->
                Article(
                    title = items.title,
                    abstract = items.abstract,
                    url = items.url,
                    byline = items.byline,
                    publishedDate = items.publishedDate,
                    multimedia = items.multimedia?.map { item ->
                        Multimedia(
                            url = item.url,
                            copyright = item.copyright
                        )
                    },
                    section = items.section,
                    checked = items.checked
                )
            }, copyright = it.copyright)
        }
    }
}