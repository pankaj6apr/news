package com.pankaj6apr.newsdaily.feature_news_sources.domain.model

import com.pankaj6apr.newsdaily.common.util.Category

data class NewsSource(
    val category: Category,
    val country: String,
    val description: String,
    val id: String,
    val language: String,
    val name: String,
    val url: String
)