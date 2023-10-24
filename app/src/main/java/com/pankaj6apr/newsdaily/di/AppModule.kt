package com.pankaj6apr.newsdaily.di

import android.app.Application
import com.pankaj6apr.newsdaily.common.util.Constants
import com.pankaj6apr.newsdaily.feature_news.data.remote.NewsDataApi
import com.pankaj6apr.newsdaily.feature_news.data.repository.NewsDataRepositoryImpl
import com.pankaj6apr.newsdaily.feature_news.domain.repository.NewsDataRepository
import com.pankaj6apr.newsdaily.feature_news_sources.data.remote.NewsSourcesApi
import com.pankaj6apr.newsdaily.feature_news_sources.data.repository.NewSourcesRepositoryImpl
import com.pankaj6apr.newsdaily.feature_news_sources.domain.repository.NewsSourcesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsDataApi(): NewsDataApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsDataApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsSourceApi(): NewsSourcesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsSourcesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDataRepository(api: NewsDataApi): NewsDataRepository {
        return NewsDataRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideNewsSourcesRepository(api: NewsSourcesApi): NewsSourcesRepository {
        return NewSourcesRepositoryImpl(api)
    }
}