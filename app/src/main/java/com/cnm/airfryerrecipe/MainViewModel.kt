package com.cnm.airfryerrecipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cnm.airfryerrecipe.data.model.CategoryResponse
import com.google.firebase.database.*

class MainViewModel : ViewModel() {
    private val firebaseDatabase: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("category")

    val categoryItems = MutableLiveData<List<CategoryResponse?>>()
    val isCallItems = MutableLiveData<Boolean>()
    val itess = CategoryResponse("1","1")
    val item = listOf<CategoryResponse?>(itess)
    fun setItems(it: List<CategoryResponse?>) {
        categoryItems.value = null
        categoryItems.value = it
        isCallItems.value = true
    }

    fun loadCategory() {
        val item = mutableListOf<CategoryResponse?>()
        isCallItems.value = false
        firebaseDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                item.clear()
                for (postSnapshot in dataSnapshot.children) {
                    item.add(postSnapshot.getValue(CategoryResponse::class.java))
                }
                setItems(item)
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                // ...
            }
        })

    }

}