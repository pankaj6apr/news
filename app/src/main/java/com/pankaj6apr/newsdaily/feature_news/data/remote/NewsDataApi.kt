package com.pankaj6apr.newsdaily.feature_news.data.remote

import com.pankaj6apr.newsdaily.common.model.SearchIn
import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.common.util.Constants
import com.pankaj6apr.newsdaily.common.util.SortBy
import com.pankaj6apr.newsdaily.feature_news.data.dto.NewsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsDataApi {
    @GET("v2/top-headlines?q={q}&sources={sources}&category={category}&country={country}&page={page}&pageSize={pageSize}&apiKey={api_key}")
    suspend fun getTopHeadlines(
        @Query("q") query: String ?= null,
        @Query("sources") sources: String ?= null, // comma separated list
        @Query("country") country: String = "us",
        @Query("category") category: Category?= null,
        @Query("page") page: Int ?= null,
        @Query("pageSize") pageSize: Int ?= null,
        @Query("apiKey") apiKey: String = Constants.API_KEY): NewsDto

    @GET("v2/everything")
    suspend fun getAllNews(
        @Query("q") query: String ?= null,
        @Query("searchIn") searchIn: SearchIn?= null,
        @Query("sources") sources: String ?= null, // comma separated list
        @Query("domains") domains: String ?= null, // comma separated list
        @Query("excludeDomains") excludeDomains: String ?= null, // comma separated list
        @Query("from") from: String ?= null,
        @Query("to") to: String ?= null,
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: SortBy?= null,
        @Query("page") page: Int ?= null,
        @Query("pageSize") pageSize: Int ?= null,
        @Query("category") category: Category?= null,
        @Query("apiKey") apiKey: String = Constants.API_KEY): NewsDto
}