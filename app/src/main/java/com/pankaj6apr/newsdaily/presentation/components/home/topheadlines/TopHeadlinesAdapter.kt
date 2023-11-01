package com.pankaj6apr.newsdaily.presentation.components.home.topheadlines

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

class TopHeadlinesAdapter(
) : RecyclerView.Adapter<TopHeadlinesAdapter.HeadlineViewHolder>() {

    private var headlines: List<Article> = listOf()

    class HeadlineViewHolder(val view: View) : ViewHolder(view) {
        val headlineImageView: ImageView = view.findViewById(R.id.headline_image)
        val headlineTitleView: TextView = view.findViewById(R.id.titleView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        return HeadlineViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_top_headlines,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = headlines.size


    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        Picasso.get().load(headlines[position].urlToImage).into(holder.headlineImageView)
        holder.headlineTitleView.setText(headlines[position].title)
    }

    fun setHeadLines(articles: List<Article>) {
        headlines = articles
        notifyDataSetChanged()
    }
}