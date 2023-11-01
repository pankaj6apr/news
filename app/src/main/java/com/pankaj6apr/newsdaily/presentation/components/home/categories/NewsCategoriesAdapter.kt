package com.pankaj6apr.newsdaily.presentation.components.home.categories

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pankaj6apr.newsdaily.R
import com.pankaj6apr.newsdaily.common.util.Category
import com.pankaj6apr.newsdaily.presentation.components.home.GetNewsViewModel
import kotlin.enums.EnumEntries

class NewsCategoriesAdapter
    (
        private val context: Context?,
        private val categoryList: EnumEntries<Category>,
        private val viewModel: GetNewsViewModel
    )
    : RecyclerView.Adapter<NewsCategoriesAdapter.NewsCategoriesViewHolder>() {

    private var selectedCategory: Int = 0

    fun setCategory(position: Int) {
        selectedCategory = position
        notifyDataSetChanged()
    }

    class NewsCategoriesViewHolder (view: View): RecyclerView.ViewHolder (view){
        val tvCategory: TextView
        val categoryCardView: CardView

        init {
            tvCategory = view.findViewById(R.id.tv_category)
            categoryCardView = view.findViewById(R.id.category_bg)
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
        if (position == selectedCategory) {
            holder.categoryCardView.setCardBackgroundColor(context!!.getColor(R.color.selectionForeground))
            holder.tvCategory.setTextColor(context!!.getColor(R.color.textPrimaryInverted))
        } else {
            holder.categoryCardView.setCardBackgroundColor(null)
            holder.categoryCardView.elevation = 0f
            holder.tvCategory.setTextColor(context!!.getColor(R.color.textPrimary))
        }
        holder.categoryCardView.setOnClickListener {
            viewModel.getHeadlines(categoryList[position])
            viewModel.setCategory(position)
        }
    }
}