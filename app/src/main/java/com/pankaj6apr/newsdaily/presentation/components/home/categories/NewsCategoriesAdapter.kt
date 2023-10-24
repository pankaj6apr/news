package com.pankaj6apr.newsdaily.presentation.components.home.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pankaj6apr.newsdaily.R
import com.pankaj6apr.newsdaily.common.util.Category
import kotlin.enums.EnumEntries

class NewsCategoriesAdapter
    (
        private val categoryList: EnumEntries<Category>
    )
    : RecyclerView.Adapter<NewsCategoriesAdapter.NewsCategoriesViewHolder>() {

    class NewsCategoriesViewHolder (view: View): RecyclerView.ViewHolder (view){
        val tvCategory: TextView

        init {
            tvCategory = view.findViewById(R.id.tv_category)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCategoriesViewHolder {
        return NewsCategoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category,
                parent, false)
        )
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: NewsCategoriesViewHolder, position: Int) {
        holder.tvCategory.text = categoryList[position].category
    }
}