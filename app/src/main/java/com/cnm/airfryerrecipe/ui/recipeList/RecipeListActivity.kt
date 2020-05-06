package com.cnm.airfryerrecipe.ui.recipeList

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cnm.airfryerrecipe.R
import com.cnm.airfryerrecipe.adapter.RecipeListAdapter
import com.cnm.airfryerrecipe.databinding.ActivityRecipeListBinding
import com.cnm.airfryerrecipe.ui.main.MainActivity
import com.cnm.airfryerrecipe.ui.main.MainViewModel

class RecipeListActivity : AppCompatActivity() {

    private val recipeListAdapter = RecipeListAdapter()
    private val listBinding by lazy {
        DataBindingUtil.setContentView<ActivityRecipeListBinding>(
            this,
            R.layout.activity_recipe_list
        )
    }
    private val viewModel: RecipeListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return RecipeListViewModel(intent.getStringExtra(MainActivity.LISTID) as String) as T
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()
        loadList()
        Log.e("1",intent.getStringExtra(MainActivity.LISTID).toString())
    }

    private fun initActivity() {
        with(listBinding) {
            rvRecipeListContent.apply {
                adapter = recipeListAdapter
                layoutManager =
                    androidx.recyclerview.widget.LinearLayoutManager(this@RecipeListActivity)
            }
            lifecycleOwner = this@RecipeListActivity
            this.vm = viewModel
        }
    }
    private fun loadList() = viewModel.loadList()
}
