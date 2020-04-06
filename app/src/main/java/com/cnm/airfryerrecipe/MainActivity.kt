package com.cnm.airfryerrecipe

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.cnm.airfryerrecipe.adapter.CategoryAdapter
import com.cnm.airfryerrecipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val categoryAdapter = CategoryAdapter()
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
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
}