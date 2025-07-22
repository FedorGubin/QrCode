package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import com.example.qrcodeapp.data.repository.FavoriteJokeRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoritesJokesUseCase @Inject constructor(
    private val repository: FavoriteJokeRepositoryImpl
) {
    fun invoke(): Flow<List<FavoriteJokeEntity>> {
        return repository.getAllJokes()
    }
}