package com.example.qrcodeapp.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
object CounterScreenKey: NavKey

@Serializable
object JokeScreenKey: NavKey

@Serializable
data class JokeDetailScreenKey(val jokeText: String): NavKey