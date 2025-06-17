package com.example.qrcodeapp.ui.Joke

data class JokeViewState(
    val isLoading: Boolean = false,
    val jokeText: String? = null,
    val error: String? = null
)