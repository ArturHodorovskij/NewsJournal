package com.example.newsjournal.data.getTopStories.models

import com.google.gson.annotations.SerializedName

data class TopStoriesNYT(
    @SerializedName("status") val status: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("section") val section: String,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("num_results") val numResults: Int,
    @SerializedName("results") val results: List<ArticleNYT>
)
