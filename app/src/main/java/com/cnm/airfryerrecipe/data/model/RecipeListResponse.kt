package com.cnm.airfryerrecipe.data.model

data class RecipeListResponse(
    val recipeId: String? = "",
    val recipeName: String? = "",
    val recipeTime: String? = "",
    val recipeTemp : String = ""
)