package com.cnm.airfryerrecipe.ui.recipeList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cnm.airfryerrecipe.R
import com.cnm.airfryerrecipe.adapter.RecipeListAdapter
import com.cnm.airfryerrecipe.databinding.ActivityRecipeListBinding

class RecipeListActivity : AppCompatActivity() {

    private val recipeListAdapter = RecipeListAdapter()
    private val listBinding by lazy {
        DataBindingUtil.setContentView<ActivityRecipeListBinding>(
            this,
            R.layout.activity_recipe_list
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()
    }

    private fun initActivity() {
        with(listBinding) {
            rvRecipeListContent.apply {
                adapter = recipeListAdapter
                layoutManager =
                    androidx.recyclerview.widget.LinearLayoutManager(this@RecipeListActivity)
            }
            lifecycleOwner = this@RecipeListActivity
//            this.vm = viewModel
        }
    }
}
