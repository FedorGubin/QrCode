package com.example.qrcodeapp.ui.Joke

sealed class JokeViewIntent {
    data object LoadJoke: JokeViewIntent()
}