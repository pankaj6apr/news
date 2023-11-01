package com.pankaj6apr.newsdaily.presentation.components.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pankaj6apr.newsdaily.R
import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.presentation.components.home.categories.NewsCategoriesAdapter
import com.pankaj6apr.newsdaily.presentation.components.home.news.NewsAdapter
import com.pankaj6apr.newsdaily.presentation.components.home.topheadlines.TopHeadlinesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var rvCategories: RecyclerView
    private lateinit var rvTopHeadlines: RecyclerView
    private lateinit var rvNews: RecyclerView
    private lateinit var newsCategoriesAdapter: NewsCategoriesAdapter
    private lateinit var headlinesAdapter: TopHeadlinesAdapter
    private lateinit var allnewsAdapter: NewsAdapter

    private val viewModel: GetNewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        rvCategories = view.findViewById(R.id.rv_news_categories)
        rvTopHeadlines = view.findViewById(R.id.rv_top_headlines)
        rvNews = view.findViewById(R.id.rv_news)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.selectedCategory.observe(viewLifecycleOwner) { it ->
            newsCategoriesAdapter?.setCategory(it)
        }
        viewModel.headlinesState.observe(viewLifecycleOwner) { headlinesState ->
            headlinesAdapter?.setHeadLines(headlinesState.news.articles)
        }
        viewModel.newsState.observe(viewLifecycleOwner) { newsState ->
            allnewsAdapter?.setNewsArticles(newsState.news.articles)
        }

        rvCategories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newsCategoriesAdapter = NewsCategoriesAdapter(context, Category.entries, viewModel)
        rvCategories.adapter = newsCategoriesAdapter

       // rvTopHeadlines.layoutManager = CarouselLayoutManager()
        rvTopHeadlines.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvNews.layoutManager = LinearLayoutManager(context)

        headlinesAdapter = TopHeadlinesAdapter()
        rvTopHeadlines.adapter = headlinesAdapter
        allnewsAdapter =  NewsAdapter()
        rvNews.adapter = allnewsAdapter

        super.onViewCreated(view, savedInstanceState)
    }
}