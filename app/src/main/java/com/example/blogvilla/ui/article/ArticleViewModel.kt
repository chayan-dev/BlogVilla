package com.example.blogvilla.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.ConduitClient
import com.example.api.models.entities.Article
import com.example.blogvilla.data.ArticlesRepo
import kotlinx.coroutines.launch

class ArticleViewModel: ViewModel() {

  val api = ConduitClient.publicApi

  private val _article = MutableLiveData<Article>()
  val article: LiveData<Article> = _article

  fun fetchArticle(slug: String) = viewModelScope.launch {
    val response = api.getArticleBySlug(slug)

    response.body()?.article.let { _article.postValue(it) }
  }

  fun createArticle(
    title:String?,
    description:String?,
    body:String?,
    tagList:List<String>?=null
  ) = viewModelScope.launch {
    val article = ArticlesRepo.createArticle(
      title=title,
      description = description,
      body=body,
      tagList = tagList
    )
  }
}