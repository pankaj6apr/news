package com.pankaj6apr.newsdaily.feature_news.data.repository

import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.feature_news.data.dto.toNews
import com.pankaj6apr.newsdaily.feature_news.data.remote.NewsDataApi
import com.pankaj6apr.newsdaily.feature_news.domain.model.News
import com.pankaj6apr.newsdaily.feature_news.domain.repository.NewsDataRepository
import javax.inject.Inject

class NewsDataRepositoryImpl @Inject constructor(private val api: NewsDataApi) : NewsDataRepository {
    override suspend fun getAllNews(): News {
        return api.getAllNews(sources = "bloomberg").toNews()
    }

    override suspend fun getTopHeadlines(category: Category): News {
        return api.getTopHeadlines(category = category).toNews()
    }
}