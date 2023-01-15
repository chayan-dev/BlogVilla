package com.example.api.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.example.api.models.entities.User

@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "user")
    val user: User
)