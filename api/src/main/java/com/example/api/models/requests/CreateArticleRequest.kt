package com.example.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.example.api.models.entities.ArticleData

@JsonClass(generateAdapter = true)
data class CreateArticleRequest(
    @Json(name = "article")
    val article: ArticleData
)