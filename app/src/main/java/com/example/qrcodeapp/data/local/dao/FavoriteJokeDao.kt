package com.example.qrcodeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteJokeDao {

    @Insert
    suspend fun insertJoke(joke: FavoriteJokeEntity)

    @Delete
    suspend fun deleteJoke(joke: FavoriteJokeEntity)

    @Query("SELECT * FROM favorite_jokes WHERE joke_text = 'alesha' ORDER BY id DESC")
    fun getAllJokes(): Flow<List<FavoriteJokeEntity>>
}