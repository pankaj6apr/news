package com.pankaj6apr.newsdaily.feature_news.domain.model

import com.pankaj6apr.newsdaily.common.model.Source

data class Article(
    val author: String?,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)