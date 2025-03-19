package com.example.newsjournal.domain.models

import com.google.gson.annotations.SerializedName

data class Multimedia(
    @SerializedName("url")  val url: String
)