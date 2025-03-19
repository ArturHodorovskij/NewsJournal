package com.example.newsjournal.domain.models

import com.google.gson.annotations.SerializedName

data class TopStoriesResponse(
    @SerializedName("results") val results: List<Article>
)
