package com.example.qrcodeapp.ui.joke.favorite_joke

import com.example.qrcodeapp.ui.base.BaseUiEvent

sealed class FavoriteJokeUIInvent : BaseUiEvent {
    data class ShowToast(val message: String) : FavoriteJokeUIInvent()
}