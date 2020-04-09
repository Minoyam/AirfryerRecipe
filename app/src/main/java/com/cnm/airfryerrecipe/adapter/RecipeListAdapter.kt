package com.cnm.airfryerrecipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cnm.airfryerrecipe.R
import com.cnm.airfryerrecipe.data.model.RecipeListResponse
import com.cnm.airfryerrecipe.databinding.ItemRecipeListBinding

class RecipeListAdapter : RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder>() {

    private val listItem = mutableListOf<RecipeListResponse?>()

    fun setItem(items: List<RecipeListResponse?>) {
        listItem.clear()
        listItem.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        val binding = DataBindingUtil.inflate<ItemRecipeListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_recipe_list, parent, false
        )
        return RecipeListViewHolder(binding)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        listItem[position]?.let { holder.bind(it) }
    }

    inner class RecipeListViewHolder(private val binding: ItemRecipeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecipeListResponse) {
            binding.items = item
        }
    }

}