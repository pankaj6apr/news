package com.pankaj6apr.newsdaily.feature_news.data.dto

import com.pankaj6apr.newsdaily.common.model.Source
import com.pankaj6apr.newsdaily.feature_news.domain.model.Article

data class ArticleDto(
    val author: String?,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)

fun ArticleDto.toArticle(): Article {
    return Article(
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        source = source,
        title = title,
        url = url,
        urlToImage = urlToImage
    );
}