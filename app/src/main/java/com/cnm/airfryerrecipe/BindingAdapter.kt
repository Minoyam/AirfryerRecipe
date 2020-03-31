package com.cnm.airfryerrecipe

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:bindImage")
fun bindImage(imageView: ImageView, imageUri: String?) {
    imageUri?.let {
        Glide.with(imageView.context).load(imageUri).override(180,180).into(imageView)
    }

}