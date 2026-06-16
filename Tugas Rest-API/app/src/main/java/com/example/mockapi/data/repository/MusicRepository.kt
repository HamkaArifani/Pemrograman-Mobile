package com.example.mockapi.data.repository

import com.example.mockapi.data.dto.toDomain
import com.example.mockapi.data.remote.ApiService
import com.example.mockapi.model.Music

class MusicRepository(private val apiService: ApiService){

    suspend fun getMusicDetail(): Result<Music> {
        return  try {
            val response = apiService.getMusic()
            val musicDomain = response.data.toDomain()
            Result.success(musicDomain)
        } catch (e: Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }
}