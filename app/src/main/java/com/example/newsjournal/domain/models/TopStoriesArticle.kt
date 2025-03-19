package com.example.newsjournal.domain.models

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("title") val title: String,
    @SerializedName("abstract") val abstract: String,
    @SerializedName("multimedia")  val multimedia: List<Multimedia>?,
)