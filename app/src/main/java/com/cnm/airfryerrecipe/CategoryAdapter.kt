package com.cnm.airfryerrecipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cnm.airfryerrecipe.R
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categoryItems = mutableListOf<CategoryResponse>()

    fun setItem(items: List<CategoryResponse>) {
        categoryItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryItems.size


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryItems[position])
    }

    inner class CategoryViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        fun bind(item: CategoryResponse) {

        }

    }
}