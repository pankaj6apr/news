package com.pankaj6apr.newsdaily.presentation.components.home.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.pankaj6apr.newsdaily.R
import com.pankaj6apr.newsdaily.feature_news.domain.model.Article
import com.pankaj6apr.newsdaily.presentation.components.home.GetNewsViewModel
import com.squareup.picasso.Picasso

class NewsAdapter(
) : RecyclerView.Adapter<NewsAdapter.HeadlineViewHolder>() {

    private var newsList: List<Article> = listOf()

    class HeadlineViewHolder(val view: View) : ViewHolder(view) {
        val imageView: ImageView
        val titleView: TextView
        val descriptionView: TextView

        init {
            imageView = view.findViewById(R.id.news_image)
            titleView = view.findViewById(R.id.titleView)
            descriptionView = view.findViewById(R.id.descriptionView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        return HeadlineViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_news,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = newsList.size


    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        Picasso.get().load(newsList[position].urlToImage).into(holder.imageView)
        holder.titleView.text = newsList[position].title
        holder.descriptionView.text = newsList[position].description
    }

    fun setNewsArticles(articles: List<Article>) {
        newsList = articles
        notifyDataSetChanged()
    }
}