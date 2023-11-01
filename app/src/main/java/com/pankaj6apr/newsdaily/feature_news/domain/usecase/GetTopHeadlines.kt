package com.pankaj6apr.newsdaily.feature_news.domain.usecase

import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.feature_news.domain.model.News
import com.pankaj6apr.newsdaily.feature_news.domain.repository.NewsDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTopHeadlines @Inject constructor(private val repository: NewsDataRepository) {
    suspend operator fun invoke(category: Category) : Flow<News> = flow {
        emit(repository.getTopHeadlines(category = category))
    }
}