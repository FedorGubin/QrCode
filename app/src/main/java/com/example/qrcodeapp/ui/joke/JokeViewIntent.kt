package com.example.qrcodeapp.ui.joke

import com.example.qrcodeapp.ui.base.BaseIntent

sealed class JokeViewIntent : BaseIntent {
    data object LoadJoke: JokeViewIntent()
}