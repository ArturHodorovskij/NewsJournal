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
            TopStories(results = it.fields.results.values.map { mapValueData ->
                val articleValue = mapValueData.mapValue.fields
                Article(
                    title = articleValue.title.stringValue,
                    abstract = articleValue.abstract.stringValue,
                    url = articleValue.url.stringValue,
                    byline = articleValue.byline.stringValue,
                    publishedDate = articleValue.publishedDate.stringValue,
                    multimedia = articleValue.multimedia.values.map { mapValueMedia ->
                        val multimediaValue = mapValueMedia.mapValue.fields
                        Multimedia(
                            copyright = multimediaValue.copyright.stringValue,
                            url = multimediaValue.url.stringValue
                        )
                    },
                    section = articleValue.section.stringValue,
                    checked = articleValue.checked.booleanValue
                )
            }, copyright = it.fields.copyright.stringValue)
        }
    }
}