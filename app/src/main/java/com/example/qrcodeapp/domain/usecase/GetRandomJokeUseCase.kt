package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.data.model.Joke
import com.example.qrcodeapp.domain.repository.JokeRepository
import javax.inject.Inject

class GetRandomJokeUseCase @Inject constructor(
    private val repository: JokeRepository
) {
    suspend fun execute(): Joke {
        return repository.getRandomJoke()
    }
}