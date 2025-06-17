package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.data.model.Joke
import com.example.qrcodeapp.domain.repository.JokeRepository

class GetRandomJokeUseCase(
    private val repository: JokeRepository
) {
    suspend fun execute(): Joke {
        return repository.getRandomJoke()
    }
}