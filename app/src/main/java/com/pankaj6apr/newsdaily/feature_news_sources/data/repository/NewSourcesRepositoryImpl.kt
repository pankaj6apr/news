package com.pankaj6apr.newsdaily.feature_news_sources.data.repository

import com.pankaj6apr.newsdaily.feature_news_sources.data.dto.toNewsSources
import com.pankaj6apr.newsdaily.feature_news_sources.data.remote.NewsSourcesApi
import com.pankaj6apr.newsdaily.feature_news_sources.domain.model.NewsSources
import com.pankaj6apr.newsdaily.feature_news_sources.domain.repository.NewsSourcesRepository
import javax.inject.Inject

class NewSourcesRepositoryImpl @Inject constructor(private val api: NewsSourcesApi) : NewsSourcesRepository {
    override suspend fun getNewsSources(): NewsSources {
        return api.getSources().toNewsSources()
    }
}