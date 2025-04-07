package com.example.newsjournal.data.getTopStories.models

import com.google.gson.annotations.SerializedName

data class ArticleNYT(
    @SerializedName("section") val section: String,
    @SerializedName("subsection") val subsection: String?,
    @SerializedName("title") val title: String,
    @SerializedName("abstract") val abstract: String,
    @SerializedName("url") val url: String,
    @SerializedName("uri") val uri: String,
    @SerializedName("byline") val byline: String?,
    @SerializedName("item_type") val itemType: String,
    @SerializedName("updated_date") val updatedDate: String,
    @SerializedName("created_date") val createdDate: String,
    @SerializedName("published_date") val publishedDate: String,
    @SerializedName("material_type_facet") val materialTypeFacet: String,
    @SerializedName("kicker") val kicker: String?,
    @SerializedName("des_facet") val desFacet: List<String>?,
    @SerializedName("org_facet") val orgFacet: List<String>?,
    @SerializedName("per_facet") val perFacet: List<String>?,
    @SerializedName("geo_facet") val geoFacet: List<String>?,
    @SerializedName("multimedia") val multimedia: List<MultimediaNYT>?,
    @SerializedName("short_url") val shortFrl: String,
    var checked: Boolean = false
)

