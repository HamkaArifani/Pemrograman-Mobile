package com.example.mockapi.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class MusicResponse (
    val message: String,
    val code: String,
    val data: MusicDto
)