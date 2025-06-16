package com.example.qrcodeapp.data.api

import com.example.qrcodeapp.data.model.Joke
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class JokeApiService(private val client: HttpClient) {
    suspend fun getRandomJoke(): Joke{
        val response: HttpResponse = client.get("https://api.chucknorris.io/jokes/random")
        return response.body()
    }
}