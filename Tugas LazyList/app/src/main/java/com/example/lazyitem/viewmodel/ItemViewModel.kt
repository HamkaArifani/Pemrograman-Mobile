package com.example.lazyitem.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lazyitem.data.DataSource
import com.example.lazyitem.model.ItemData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemViewModel: ViewModel() {
    val dataSource= DataSource()

    private val _itemList= MutableStateFlow<List<ItemData>>(emptyList())
    val itemlist: StateFlow<List<ItemData>> = _itemList

    fun loadData(){
        val data = dataSource.listData()
        _itemList.value=data
    }
    init{
        loadData()
    }
    fun updateSwitchState(itemId: Int, isChecked : Boolean){
        _itemList.value= _itemList.value.map{ item->
            if(item.id==itemId){
                item.copy(isSwitched = isChecked)
            }
            else{
                item
            }
        }
    }
}