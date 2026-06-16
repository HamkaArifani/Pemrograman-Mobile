package com.example.mockapi.data.repository

import com.example.mockapi.data.dto.toDomain
import com.example.mockapi.data.remote.ApiService
import com.example.mockapi.model.Music

class MusicRepository(private val apiService: ApiService){

    suspend fun getMusicDetail(): Music {
        return apiService.getMusic().data.toDomain()
    }
}