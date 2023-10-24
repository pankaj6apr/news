package com.pankaj6apr.newsdaily.feature_news_sources.usecase

import com.pankaj6apr.newsdaily.feature_news_sources.domain.model.NewsSources
import com.pankaj6apr.newsdaily.feature_news_sources.domain.repository.NewsSourcesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsSources @Inject constructor(
    private val repository: NewsSourcesRepository
) {
    operator fun invoke() : Flow<NewsSources> = flow {
        emit(repository.getNewsSources())
    }
}