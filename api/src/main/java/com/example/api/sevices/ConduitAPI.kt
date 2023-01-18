package com.example.api.sevices

import com.example.api.models.requests.LoginRequest
import com.example.api.models.requests.SignupRequest
import com.example.api.models.responses.ArticleResponse
import com.example.api.models.responses.ArticlesResponse
import com.example.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

  @POST("users")
  suspend fun signupUser(
    @Body userCreds: SignupRequest
  ): Response<UserResponse>

  @POST("users/login")
  suspend fun loginUser(
    @Body userCreds: LoginRequest
  ): Response<UserResponse>

  @GET("articles")
  suspend fun getArticles(
    @Query("author") author: String? = null,
    @Query("favourited") favourited: String? = null,
    @Query("tag") tag: String? = null
  ): Response<ArticlesResponse>

  @GET("articles/{slug}")
  suspend fun getArticleBySlug(
    @Path("slug") slug: String
  ): Response<ArticleResponse>
}