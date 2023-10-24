package com.pankaj6apr.newsdaily.feature_news_sources.domain.model

import com.pankaj6apr.newsdaily.common.model.ErrorCode

data class NewsSources(
    val sources: List<NewsSource>,
    val code: String?,
    val message: String?,
    val status: ErrorCode
)