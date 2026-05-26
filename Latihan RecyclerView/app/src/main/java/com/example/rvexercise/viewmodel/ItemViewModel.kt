package com.example.rvexercise.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rvexercise.data.DataSource
import com.example.rvexercise.model.ItemData

class ItemViewModel: ViewModel() {
    val dataSource= DataSource()

    private val _itemList= MutableLiveData<List<ItemData>>()
    val itemlist: LiveData<List<ItemData>> = _itemList

    fun loadData(){
        val data = dataSource.listData()
        _itemList.value=data
    }
}