package com.cnm.airfryerrecipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val categoryAdapter = CategoryAdapter()
    private val item = listOf<CategoryResponse>(CategoryResponse("치킨", R.mipmap.ic_launcher_round))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_content.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
        categoryAdapter.setItem(item)
    }
}
