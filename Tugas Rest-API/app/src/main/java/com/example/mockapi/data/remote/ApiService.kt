package com.example.mockapi.data.remote

import com.example.mockapi.data.dto.MusicDto
import com.example.mockapi.data.dto.MusicResponse
import com.example.mockapi.model.Music
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {
    private val BASE_URL = "https://mobile-practice-mock-api.free.beeceptor.com"

    suspend fun getMusic(): MusicResponse{
        return client.get("$BASE_URL/music").body()
    }
}