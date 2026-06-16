package com.example.mockapi

import com.example.mockapi.data.remote.ApiService
import com.example.mockapi.data.repository.MusicRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object NetworkModule {
    val httpClient = HttpClient(Android) {
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }
    val apiService = ApiService(httpClient)
    val repository = MusicRepository(apiService)
}