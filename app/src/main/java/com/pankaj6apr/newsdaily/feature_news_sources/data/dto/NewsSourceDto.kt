package com.pankaj6apr.newsdaily.feature_news_sources.data.dto

import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.feature_news_sources.domain.model.NewsSource

data class NewsSourceDto(
    val category: Category,
    val country: String,
    val description: String,
    val id: String,
    val language: String,
    val name: String,
    val url: String
)

fun NewsSourceDto.toNewsSource() : NewsSource {
    return NewsSource(
        category = category,
        country = country,
        description = description,
        id = id,
        language = language,
        name = name,
        url = url
    )
}