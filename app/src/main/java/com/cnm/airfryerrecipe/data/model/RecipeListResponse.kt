package com.cnm.airfryerrecipe.data.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class RecipeListResponse(
    val recipeListImage: String? = "",
    val recipeListName: String? = "",
    val recipeListTime: Int? = 0
)