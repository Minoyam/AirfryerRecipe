package com.cnm.airfryerrecipe.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cnm.airfryerrecipe.data.model.CategoryResponse

@BindingAdapter("bind:bindImage")
fun bindImage(imageView: ImageView, imageUri: String?) {
    imageUri?.let {
        Glide.with(imageView.context).load(imageUri).override(180, 180).into(imageView)
    }

}

@BindingAdapter("bind:bindSetCategoryItem")
fun RecyclerView.bindSetCategoryItem(items: List<CategoryResponse?>) {
    if (adapter is CategoryAdapter)
        items.let {
            (adapter as CategoryAdapter).setItem(it)
        }
}