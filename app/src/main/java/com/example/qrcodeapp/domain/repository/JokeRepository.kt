package com.example.qrcodeapp.domain.repository

import com.example.qrcodeapp.data.model.Joke

interface JokeRepository {
    suspend fun getRandomJoke(): Joke
}