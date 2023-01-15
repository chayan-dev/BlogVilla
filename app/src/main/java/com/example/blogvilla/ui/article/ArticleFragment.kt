package com.example.blogvilla.ui.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.blogvilla.R
import com.example.blogvilla.databinding.FragmentArticleBinding
import io.realworld.android.extensions.loadImage
import io.realworld.android.extensions.timeStamp

class ArticleFragment : Fragment() {

  private var _binding: FragmentArticleBinding? = null
  lateinit var articleViewModel: ArticleViewModel
  private var articleId: String? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
    _binding = FragmentArticleBinding.inflate(inflater, container, false)

    return _binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    articleViewModel.article.observe({ lifecycle }) {
      _binding?.apply {
        titleTextView.text = it.title
        bodyTextView.text = it.body
        authorTextView.text = it.author.username
        dateTextView.timeStamp = it.createdAt
        avatarImageView.loadImage(it.author.image, true)
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

}