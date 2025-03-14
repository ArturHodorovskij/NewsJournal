package com.example.newsjournal.domain

import com.google.gson.annotations.SerializedName

data class TopStoriesResponse(
    @SerializedName("status") val status: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("section") val section: String,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("num_results") val numResults: Int,
    @SerializedName("results") val results: List<Article>
)
