package com.example.qrcodeapp

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.http.ContentType
import javax.inject.Inject

class NetworkService @Inject constructor(private val client: HttpClient){
    suspend fun ping(): Boolean {
        return try {
            val response: String = client.get("https://httpbin.org/get") {
                accept(ContentType.Application.Json)
            }.body()
            println("Ping success: $response")
            true
        }
        catch (e: Exception) {
            println("Ping failed: ${e.localizedMessage}")
            false
        }
    }
}