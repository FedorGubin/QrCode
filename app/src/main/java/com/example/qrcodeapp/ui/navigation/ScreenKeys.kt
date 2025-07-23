package com.example.qrcodeapp.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

interface FirstStack: NavKey

interface SecondStack: NavKey

interface ThirdStack: NavKey


@Serializable
object CounterScreenKey: FirstStack

@Serializable
object JokeScreenKey: FirstStack

@Serializable
object  FavoriteJokeScreenKey: FirstStack

@Serializable
data class JokeDetailScreenKey(val jokeText: String): FirstStack







@Serializable
object SecondScreen: SecondStack

@Serializable
object ThirdScreen: ThirdStack