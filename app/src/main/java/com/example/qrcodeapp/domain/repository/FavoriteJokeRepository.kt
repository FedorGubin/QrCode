package com.example.qrcodeapp.domain.repository

import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity

interface FavoriteJokeRepository {
    suspend fun addJoke(joke: FavoriteJokeEntity)
    suspend fun deleteJoke(joke: FavoriteJokeEntity)
}