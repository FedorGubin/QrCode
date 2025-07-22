package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import com.example.qrcodeapp.data.repository.FavoriteJokeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoritesJokesUseCase @Inject constructor(
    private val repository: FavoriteJokeRepository
) {
    fun invoke(): Flow<List<FavoriteJokeEntity>> {
        return repository.addAllJokes()
    }
}