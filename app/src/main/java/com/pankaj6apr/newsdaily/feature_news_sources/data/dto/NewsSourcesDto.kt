package com.pankaj6apr.newsdaily.feature_news_sources.data.dto

import com.pankaj6apr.newsdaily.common.model.ErrorCode
import com.pankaj6apr.newsdaily.feature_news_sources.domain.model.NewsSources

data class NewsSourcesDto(
    val sources: List<NewsSourceDto>,
    val code: String?,
    val message: String?,
    val status: ErrorCode
)

fun NewsSourcesDto.toNewsSources(): NewsSources {
    return NewsSources(
        sources = sources.map { it.toNewsSource() },
        status = status,
        code = code,
        message = message
    )
}