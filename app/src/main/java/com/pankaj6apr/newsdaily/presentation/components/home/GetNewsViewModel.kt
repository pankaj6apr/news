package com.pankaj6apr.newsdaily.presentation.components.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankaj6apr.newsdaily.common.model.ErrorCode
import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.feature_news.domain.model.News
import com.pankaj6apr.newsdaily.feature_news.domain.usecase.GetAllNews
import com.pankaj6apr.newsdaily.feature_news.domain.usecase.GetTopHeadlines
import com.pankaj6apr.newsdaily.presentation.components.home.topheadlines.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetNewsViewModel @Inject constructor(
    private val getTopHeadlines: GetTopHeadlines,
    private val getAllNews: GetAllNews,
   // private val getNewsSources: GetNewsSources
) : ViewModel() {
//    private val _state = mutableStateOf(NewsState(NewsSources(listOf(),null, null, ErrorCode.OK)))
//    val state: State<NewsState> = _state

    private val _newsState = MutableLiveData<NewsState>(NewsState(News(listOf(), null, null,ErrorCode.OK, 10)))
    val newsState: LiveData<NewsState> = _newsState

    private val _headlinesState = MutableLiveData<NewsState>(NewsState(News(listOf(), null, null,ErrorCode.OK, 10)))
    val headlinesState: LiveData<NewsState> = _headlinesState

    private val _selectedCategory = MutableLiveData<Int>(0)
    val selectedCategory: LiveData<Int> = _selectedCategory

    init {
        getNews()
        getHeadlines()
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
    fun getHeadlines(category: Category = Category.GENERAL) {
        viewModelScope.launch {
            getTopHeadlines(category).collect{
                _headlinesState.value = NewsState(it)
            }
        }
    }
    fun setCategory(pos: Int) {
        _selectedCategory.value = pos
    }
}
