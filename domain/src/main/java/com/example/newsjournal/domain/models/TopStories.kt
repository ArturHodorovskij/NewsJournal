package com.example.newsjournal.domain.models

data class TopStories(
    val results: List<Article>,
    val copyright: String
)

//kotlin.collections.CollectionsKt_Iterables Kt.collectionSizeorDefault, parameter <this>