package com.example.lazyitem.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ItemData (
    val id: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
    val isSwitched: Boolean = false
)