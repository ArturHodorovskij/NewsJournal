package com.example.newsjournal.data.firestore.models

data class FirestoreResponse(
    val fields: NewsFields
)

data class NewsFields(
    val copyright: FieldValue,
    val results: Results
)

data class FieldValue(
    val stringValue: String? = null,
    val arrayValue: ArrayValue? = null,
    val booleanValue: Boolean? = null
)

data class ArrayValue(
    val values: List<MapValueMedia>
)

data class MapValueMedia(
    val mapValue: MapValueFields
)

data class MapValueFields(
    val fields: MultimediaFields
)

data class MultimediaFields(
    val copyright: FieldValue,
    val url: FieldValue
)

data class Results(
    val values: List<MapValueData>
)

data class MapValueData(
    val mapValue: MapValueFieldsData
)

data class MapValueFieldsData(
    val fields: NewsData
)

data class NewsData(
    val abstract: FieldValue,
    val byline: FieldValue,
    val checked: FieldValue,
    val multimedia: ArrayValue,
    val publishedDate: FieldValue,
    val section: FieldValue,
    val title: FieldValue,
    val url: FieldValue
)