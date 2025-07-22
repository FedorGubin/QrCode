package com.example.qrcodeapp.data.repository

import androidx.room.Delete
import androidx.room.Insert
import com.example.qrcodeapp.data.local.dao.FavoriteJokeDao
import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteJokeRepository @Inject constructor(
    private val dao: FavoriteJokeDao
) {
    suspend fun addJoke(joke: FavoriteJokeEntity) {
        dao.insertJoke(joke)
    }

    suspend fun deleteJoke(joke: FavoriteJokeEntity) {
        dao.deleteJoke(joke)
    }

    fun addAllJokes(): Flow<List<FavoriteJokeEntity>> {
        return dao.getAllJokes()
    }

}