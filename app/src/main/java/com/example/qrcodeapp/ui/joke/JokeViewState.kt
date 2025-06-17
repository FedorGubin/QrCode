package com.example.qrcodeapp.ui.joke

import com.example.qrcodeapp.ui.base.BaseState

data class JokeViewState(
    val isLoading: Boolean = false,
    val jokeText: String? = null,
    val error: String? = null
) : BaseState