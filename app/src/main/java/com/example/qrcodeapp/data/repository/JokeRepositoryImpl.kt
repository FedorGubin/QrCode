package com.example.qrcodeapp.data.repository

import com.example.qrcodeapp.data.api.JokeApiService
import com.example.qrcodeapp.data.model.Joke
import com.example.qrcodeapp.domain.repository.JokeRepository

class JokeRepositoryImpl(
    private val apiService: JokeApiService
): JokeRepository {
    override suspend fun getRandomJoke(): Joke {
        return apiService.getRandomJoke()
    }
}