package com.example.api.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.example.api.models.entities.Profile

@JsonClass(generateAdapter = true)
data class ProfileResponse(
    @Json(name = "profile")
    val profile: Profile
)