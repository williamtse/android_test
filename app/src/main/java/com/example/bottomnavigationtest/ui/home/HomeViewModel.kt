package com.example.bottomnavigationtest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bottomnavigationtest.Adapter.ProductAdapter
import com.example.bottomnavigationtest.Model.Product

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    private val _liveData = MutableLiveData<ProductAdapter>().apply {

    }
    val liveData:LiveData<ProductAdapter> = _liveData
}