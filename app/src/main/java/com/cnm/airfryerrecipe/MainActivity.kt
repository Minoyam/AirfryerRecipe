package com.cnm.airfryerrecipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.cnm.airfryerrecipe.databinding.ActivityMainBinding
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private val categoryAdapter = CategoryAdapter()
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
    lateinit var firebaseDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("category")
        binding.rvContent.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

        firebaseDatabase.addValueEventListener(object : ValueEventListener {
            val item = mutableListOf<CategoryResponse?>()
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                item.clear()
                for (postSnapshot in dataSnapshot.children) {
                    item.add(postSnapshot.getValue(CategoryResponse::class.java))
                }
                categoryAdapter.setItem(item)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                // ...
            }
        })

    }

}
