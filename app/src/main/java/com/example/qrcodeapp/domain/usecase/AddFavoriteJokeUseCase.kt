package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import com.example.qrcodeapp.data.repository.FavoriteJokeRepositoryImpl
import javax.inject.Inject

class AddFavoriteJokeUseCase @Inject constructor(
    private val repository: FavoriteJokeRepositoryImpl
) {
    suspend fun execute(joke: FavoriteJokeEntity) {
        repository.addJoke(joke)
    }
}