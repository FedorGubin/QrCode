package com.example.qrcodeapp.data.repository

import com.example.qrcodeapp.data.local.dao.FavoriteJokeDao
import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import com.example.qrcodeapp.domain.repository.FavoriteJokeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteJokeRepositoryImpl @Inject constructor(
    private val dao: FavoriteJokeDao
): FavoriteJokeRepository {
    override suspend fun addJoke(joke: FavoriteJokeEntity) {
        return dao.insertJoke(joke)
    }

    override suspend fun deleteJoke(joke: FavoriteJokeEntity){
        return dao.deleteJoke(joke)
    }

    fun getAllJokes(): Flow<List<FavoriteJokeEntity>> {
        return dao.getAllJokes()
    }

}