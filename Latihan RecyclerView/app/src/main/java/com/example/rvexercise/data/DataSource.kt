package com.example.rvexercise.data

import com.example.rvexercise.R
import com.example.rvexercise.model.ItemData

class DataSource {
    fun listData() : List<ItemData>{
        return listOf(
            ItemData(
                1,
                R.string.itemtitle1,
                R.string.itemdesc1,
                R.drawable.android
            ),
            ItemData(
                2,
                R.string.itemtitle2,
                R.string.itemdesc2,
                R.drawable.android
            ),
            ItemData(
                3,
                R.string.itemtitle3,
                R.string.itemdesc3,
                R.drawable.android
            ),
            ItemData(
                4,
                R.string.itemtitle4,
                R.string.itemdesc4,
                R.drawable.android
            ),
            ItemData(
                5,
                R.string.itemtitle5,
                R.string.itemdesc5,
                R.drawable.android
            )
        )
    }
}