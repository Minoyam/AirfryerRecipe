package com.cnm.airfryerrecipe.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.cnm.airfryerrecipe.R
import com.cnm.airfryerrecipe.adapter.CategoryAdapter
import com.cnm.airfryerrecipe.data.model.CategoryResponse
import com.cnm.airfryerrecipe.databinding.ActivityMainBinding
import com.cnm.airfryerrecipe.ui.recipeList.RecipeListActivity

class MainActivity : AppCompatActivity() {
    private val categoryAdapter =
        CategoryAdapter(::showRecipeList)
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }
    private val viewModel: MainViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel() as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()
        loadCategory()
    }

    private fun loadCategory() = viewModel.loadCategory()

    private fun initActivity() {
        with(binding) {
            rvContent.apply {
                adapter = categoryAdapter
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
            lifecycleOwner = this@MainActivity
            this.vm = viewModel
        }
    }

    private fun showRecipeList(item: CategoryResponse) {
        val intent = Intent(this, RecipeListActivity::class.java)
        intent.putExtra(LISTID, item.categoryId)
        startActivity(intent)
    }
    companion object{
        const val LISTID = "Id"
    }
}