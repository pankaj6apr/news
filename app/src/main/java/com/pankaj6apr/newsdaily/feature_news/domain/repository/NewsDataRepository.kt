package com.pankaj6apr.newsdaily.feature_news.domain.repository

import com.pankaj6apr.newsdaily.feature_news.domain.model.News

interface NewsDataRepository {
    suspend fun getTopHeadlines(): News
    suspend fun getAllNews(): News
}