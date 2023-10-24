package com.pankaj6apr.newsdaily.feature_news.data.repository

import com.pankaj6apr.newsdaily.feature_news.data.dto.toNews
import com.pankaj6apr.newsdaily.feature_news.data.remote.NewsDataApi
import com.pankaj6apr.newsdaily.feature_news.domain.model.News
import com.pankaj6apr.newsdaily.feature_news.domain.repository.NewsDataRepository
import javax.inject.Inject

class NewsDataRepositoryImpl @Inject constructor(private val api: NewsDataApi) : NewsDataRepository {
    override suspend fun getAllNews(): News {
        return api.getAllNews("cricket").toNews()
    }

    override suspend fun getTopHeadlines(): News {
        return api.getTopHeadlines().toNews()
    }
}