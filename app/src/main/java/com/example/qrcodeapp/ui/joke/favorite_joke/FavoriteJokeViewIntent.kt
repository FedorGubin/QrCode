package com.example.qrcodeapp.ui.joke.favorite_joke

import com.example.qrcodeapp.ui.base.BaseIntent

sealed class FavoriteJokeViewIntent : BaseIntent {
    data object LoadFavoritesJokes : FavoriteJokeViewIntent()
    data class RemoveFavoritesJokes(val jokeText: String) : FavoriteJokeViewIntent()
}