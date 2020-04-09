package com.cnm.airfryerrecipe

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class CategoryResponse(
    val categoryName: String? = "",
    val categoryImage: String? = ""
)