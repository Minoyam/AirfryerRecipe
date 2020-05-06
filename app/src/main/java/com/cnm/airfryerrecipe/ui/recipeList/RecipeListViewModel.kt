package com.cnm.airfryerrecipe.ui.recipeList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cnm.airfryerrecipe.data.model.CategoryResponse
import com.cnm.airfryerrecipe.data.model.RecipeListResponse
import com.google.firebase.database.*

class RecipeListViewModel(id: String?) : ViewModel() {
    private val path = "category/list/$id"
    private val firebaseDatabase: DatabaseReference =
        FirebaseDatabase.getInstance().getReference(path)
    val listItems = MutableLiveData<List<RecipeListResponse?>>()
    val isCallItems = MutableLiveData<Boolean>()
    private val itess = RecipeListResponse("1", "1","1","1")
    val item = listOf<RecipeListResponse?>(itess)

    fun setItems(it: List<RecipeListResponse?>) {
        listItems.value = null
        listItems.value = it
        isCallItems.value = true
    }

    fun loadList() {
        val item = mutableListOf<RecipeListResponse?>()
        isCallItems.value = false
        firebaseDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                item.clear()
                for (postSnapshot in dataSnapshot.children) {
                    item.add(postSnapshot.getValue(RecipeListResponse::class.java))
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