package com.pankaj6apr.newsdaily.feature_news.domain.model

import com.pankaj6apr.newsdaily.common.model.ErrorCode

data class News(
    val articles: List<Article>,
    val code: String?,
    val message: String?,
    val status: ErrorCode,
    val totalResults: Int
)
