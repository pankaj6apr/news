package com.pankaj6apr.newsdaily.presentation.components.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.newsdaily.common.model.ErrorCode
import com.pankaj6apr.newsdaily.feature_news.domain.model.News
import com.pankaj6apr.newsdaily.feature_news.domain.usecase.GetAllNews
import com.pankaj6apr.newsdaily.presentation.components.home.topheadlines.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetNewsViewModel @Inject constructor(
    private val getAllNews: GetAllNews,
   // private val getNewsSources: GetNewsSources
) : ViewModel() {
//    private val _state = mutableStateOf(NewsState(NewsSources(listOf(),null, null, ErrorCode.OK)))
//    val state: State<NewsState> = _state

    private val _newsState = mutableStateOf(NewsState(News(listOf(), null, null,ErrorCode.OK, 10)))
    val newsState: State<NewsState> = _newsState

    init {
        getNews()
      //  getSources()
    }

//    private fun getSources() {
//        viewModelScope.launch {
//            getNewsSources().collect {
//                _state.value = NewsState(it)
//            }
//        }
//    }
    private fun getNews() {
        viewModelScope.launch {
            getAllNews().collect{
                _newsState.value = NewsState(it)
            }
        }
    }
}