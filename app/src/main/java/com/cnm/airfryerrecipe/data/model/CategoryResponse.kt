package com.cnm.airfryerrecipe.data.model

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class CategoryResponse(
    val categoryName: String? = "",
    val categoryImage: String? = ""
)