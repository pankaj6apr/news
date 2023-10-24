package com.pankaj6apr.newsdaily.presentation.components.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselLayoutManager.HORIZONTAL
import com.google.android.material.carousel.HeroCarouselStrategy
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
        rvCategories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = NewsCategoriesAdapter(Category.entries)

       // rvTopHeadlines.layoutManager = CarouselLayoutManager()
        rvTopHeadlines.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvTopHeadlines.adapter = TopHeadlinesAdapter(viewModel.newsState.value.news.articles)

        rvNews.layoutManager = LinearLayoutManager(context)
        rvNews.adapter = NewsAdapter(viewModel.newsState.value.news.articles)
        super.onViewCreated(view, savedInstanceState)
    }
}