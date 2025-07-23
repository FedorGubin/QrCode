package com.example.qrcodeapp.ui.joke.favorite_joke

import com.example.qrcodeapp.ui.base.BaseState

data class FavoriteJokeViewState(
    val jokes: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val isError: String? = null
): BaseState
