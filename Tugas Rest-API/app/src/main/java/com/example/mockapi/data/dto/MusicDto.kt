package com.example.mockapi.data.dto

import com.example.mockapi.model.Music
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MusicDto (
    @SerialName("Title") val title: String,
    @SerialName("Composer") val composer: String,
    @SerialName("Duration") val duration : String,
    @SerialName("Made For") val madeFor: String
)

fun MusicDto.toDomain() = Music(
    title = title,
    composer = composer,
    duration = duration,
    madeFor = madeFor
)