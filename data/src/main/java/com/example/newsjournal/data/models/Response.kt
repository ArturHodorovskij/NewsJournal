package com.example.newsjournal.data.models

import com.example.newsjournal.domain.models.Article
import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("status") val status: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("section") val section: String,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("num_results") val numResults: Int,
    @SerializedName("results") val results: List<Article>
)
