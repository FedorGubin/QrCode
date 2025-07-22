package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import com.example.qrcodeapp.data.repository.FavoriteJokeRepository
import javax.inject.Inject

class DeleteFavoriteJokeUseCase @Inject constructor(
    private val repository: FavoriteJokeRepository
) {
    suspend fun execute(joke: FavoriteJokeEntity) {
        repository.deleteJoke(joke)
    }
}