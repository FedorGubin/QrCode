package com.example.qrcodeapp.domain.repository

import com.example.qrcodeapp.data.api.JokeApiService
import com.example.qrcodeapp.data.model.Joke

class JokeRepositoryImpl(
    private val apiService: JokeApiService
): JokeRepository {
    override suspend fun getRandomJoke(): Joke {
        return apiService.getRandomJoke()
    }

}