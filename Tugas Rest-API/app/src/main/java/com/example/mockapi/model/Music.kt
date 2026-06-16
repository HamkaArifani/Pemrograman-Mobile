package com.example.mockapi.model

import kotlinx.serialization.Serializable

@Serializable
data class Music (
    val title: String,
    val composer: String,
    val duration: String,
    val madeFor: String
)