package com.example.newsjournal.data.nyt.repository

import com.example.newsjournal.data.nyt.network.TopStoriesNetwork
import com.example.newsjournal.domain.models.NYT.Article
import com.example.newsjournal.domain.models.NYT.Multimedia
import com.example.newsjournal.domain.models.NYT.TopStories
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


