package com.pankaj6apr.newsdaily.feature_news.domain.usecase

import com.pankaj6apr.newsdaily.feature_news.domain.model.News
import com.pankaj6apr.newsdaily.feature_news.domain.repository.NewsDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllNews @Inject constructor(
    private val repository: NewsDataRepository
) {
    operator fun invoke() : Flow<News> = flow {
        emit(repository.getAllNews())
    }
}