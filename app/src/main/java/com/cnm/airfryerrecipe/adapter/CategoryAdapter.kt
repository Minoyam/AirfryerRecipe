package com.cnm.airfryerrecipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cnm.airfryerrecipe.R
import com.cnm.airfryerrecipe.data.model.CategoryResponse
import com.cnm.airfryerrecipe.databinding.ItemCategoryBinding

class CategoryAdapter(private val onClickAction: (CategoryResponse) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categoryItems = mutableListOf<CategoryResponse?>()

    fun setItem(items: List<CategoryResponse?>) {
        categoryItems.clear()
        categoryItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = DataBindingUtil.inflate<ItemCategoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_category, parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = categoryItems.size


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        categoryItems[position]?.let { holder.bind(it) }
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val item = categoryItems[adapterPosition] as CategoryResponse
                onClickAction(item)
            }
        }

        fun bind(item: CategoryResponse) {
            binding.items = item
        }

    }
}