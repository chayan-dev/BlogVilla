package com.example.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.example.api.models.entities.LoginData

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val user: LoginData
)