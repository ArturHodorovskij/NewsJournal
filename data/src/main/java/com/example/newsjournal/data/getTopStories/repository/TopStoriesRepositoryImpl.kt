package com.example.newsjournal.data.getTopStories.repository

import com.example.newsjournal.data.getTopStories.network.TopStoriesNetwork
import com.example.newsjournal.domain.models.Article
import com.example.newsjournal.domain.models.Multimedia
import com.example.newsjournal.domain.models.TopStories
import com.example.newsjournal.domain.network.TopStoriesRepository

class TopStoriesRepositoryImpl(private val topStoriesFromNetwork: TopStoriesNetwork) :
    TopStoriesRepository {
    override suspend fun getTopStoriesValue(section: String): TopStories? {
        val topStoriesValue = topStoriesFromNetwork.getTopStoriesValue(section)

        return topStoriesValue?.let {
            TopStories(results = it.results.map { items ->
                Article(
                    title = items.title,
                    abstract = items.abstract,
                    url = items.url,
                    byline = items.byline,
                    publishedDate = items.publishedDate,
                    updatedDate = items.updatedDate,
                    createdDate = items.createdDate,
                    multimedia = items.multimedia?.map { item ->
                        Multimedia(
                            url = item.url,
                            copyright = item.copyright
                        )
                    },
                )
            }, copyright = it.copyright)
        }
    }
}


