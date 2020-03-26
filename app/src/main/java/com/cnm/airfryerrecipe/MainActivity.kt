package com.cnm.airfryerrecipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.cnm.airfryerrecipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val categoryAdapter = CategoryAdapter()
    private val item =
        listOf(CategoryResponse("치킨", R.drawable.ic_launcher_background))
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.rvContent.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
        categoryAdapter.setItem(item)
    }
}
