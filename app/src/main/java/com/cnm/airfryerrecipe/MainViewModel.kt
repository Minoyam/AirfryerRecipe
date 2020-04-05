package com.cnm.airfryerrecipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cnm.airfryerrecipe.data.model.CategoryResponse
import com.cnm.airfryerrecipe.data.repository.AirfryerRepositoryImpl
import com.cnm.airfryerrecipe.data.source.db.AirfryerFirebaseImpl
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainViewModel : ViewModel() {
    private val firebaseDatabase: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("category")
    private val airfryerRepositoryImpl: AirfryerRepositoryImpl by lazy {
        AirfryerRepositoryImpl(AirfryerFirebaseImpl(firebaseDatabase))
    }
    val categoryItems = MutableLiveData<List<CategoryResponse>>()
    fun setItems(it: List<CategoryResponse>) {
        categoryItems.value = null
        categoryItems.value = it
    }

    fun loadCategory(): List<CategoryResponse> =
        airfryerRepositoryImpl.loadCategory()

}