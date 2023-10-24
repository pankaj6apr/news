package com.pankaj6apr.newsdaily.feature_news_sources.domain.repository

import com.pankaj6apr.newsdaily.feature_news_sources.domain.model.NewsSources

interface NewsSourcesRepository {
    suspend fun getNewsSources(): NewsSources
}