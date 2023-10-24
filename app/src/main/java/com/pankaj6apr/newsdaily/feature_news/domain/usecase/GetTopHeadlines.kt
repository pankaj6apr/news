package com.pankaj6apr.newsdaily.feature_news.domain.usecase

import com.pankaj6apr.newsdaily.feature_news.domain.model.News
import com.pankaj6apr.newsdaily.feature_news.domain.repository.NewsDataRepository

class GetTopHeadlines(private val repository: NewsDataRepository) {
    suspend operator fun invoke() : News {
        return repository.getTopHeadlines()
    }
}