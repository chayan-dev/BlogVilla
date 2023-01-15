package com.example.api.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.example.api.models.entities.Comment

@JsonClass(generateAdapter = true)
data class CommentResponse(
    @Json(name = "comment")
    val comments: Comment
)