package com.example.blogvilla.data

import com.example.api.ConduitClient
import com.example.api.models.entities.Article
import com.example.api.models.entities.ArticleData
import com.example.api.models.requests.UpsertArticleRequest

object ArticlesRepo {

  val api = ConduitClient.publicApi
  val authApi = ConduitClient.authApi

  suspend fun createArticle(
    title:String?,
    description:String?,
    body:String?,
    tagList:List<String>?=null
  ) : Article? {
    val response = authApi.createArticle(
      UpsertArticleRequest(
        ArticleData(
          title=title,
          description = description,
          body = body,
          tagList = tagList
        )
      )
    )

    return response.body()?.article
  }
}