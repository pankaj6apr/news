package com.pankaj6apr.newsdaily.feature_news.domain.repository

import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.feature_news.domain.model.News

interface NewsDataRepository {
    suspend fun getTopHeadlines(category: Category): News
    suspend fun getAllNews(): News
}