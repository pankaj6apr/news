package com.pankaj6apr.newsdaily.feature_news.data.dto

import com.pankaj6apr.newsdaily.common.model.ErrorCode
import com.pankaj6apr.newsdaily.feature_news.domain.model.News

data class NewsDto(
    val articles: List<ArticleDto>,
    val code: String?,
    val message: String?,
    val status: ErrorCode,
    val totalResults: Int
)

fun NewsDto.toNews(): News {
    return News(
        articles = articles.map { it.toArticle() },
        status = status,
        message = message,
        code = code,
        totalResults = totalResults
    );
}