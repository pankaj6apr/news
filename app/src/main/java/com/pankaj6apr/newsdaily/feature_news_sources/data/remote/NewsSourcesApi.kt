package com.pankaj6apr.newsdaily.feature_news_sources.data.remote

import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.common.util.Constants
import com.pankaj6apr.newsdaily.feature_news_sources.data.dto.NewsSourcesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsSourcesApi {
    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("country") country: String ?= "us",
        @Query("language") language: String ?= "en",
        @Query("category") category: Category ?= null,
        @Query("apiKey") apiKey: String = Constants.API_KEY): NewsSourcesDto
}