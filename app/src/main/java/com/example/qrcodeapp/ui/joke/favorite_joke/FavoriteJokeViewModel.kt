package com.example.qrcodeapp.ui.joke.favorite_joke

import androidx.lifecycle.viewModelScope
import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import com.example.qrcodeapp.domain.usecase.DeleteFavoriteJokeUseCase
import com.example.qrcodeapp.domain.usecase.GetAllFavoritesJokesUseCase
import com.example.qrcodeapp.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteJokeViewModel @Inject constructor(
    private val getAllFavoritesJokesUseCase: GetAllFavoritesJokesUseCase,
    private val deleteFavoriteJokeUseCase: DeleteFavoriteJokeUseCase
) : BaseViewModel<FavoriteJokeViewState, FavoriteJokeUIInvent, FavoriteJokeViewIntent>(
    FavoriteJokeViewState()
) {
    override fun onIntent(intent: FavoriteJokeViewIntent) {
        when (intent) {
            is FavoriteJokeViewIntent.LoadFavoritesJokes ->loadJoke()
            is FavoriteJokeViewIntent.RemoveFavoritesJokes -> remoteJoke(intent.jokeText)
        }
    }

    private fun loadJoke() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, isError = null) }
            getAllFavoritesJokesUseCase.invoke()
                .catch { error ->
                    updateState {
                        it.copy(
                            isLoading = false,
                            isError = error.message ?: "Неизвестная ошибка"
                        )

                    }
                }
                .collectLatest { jokes ->
                    updateState {
                        it.copy(
                            isLoading = false,
                            jokes = jokes.map { joke -> joke.jokeText }
                        )
                    }
                }
        }
    }

    private fun remoteJoke(jokeText: String) {
        viewModelScope.launch {
            try {
                deleteFavoriteJokeUseCase.execute(joke = FavoriteJokeEntity(jokeText = jokeText))
                updateUiEvent(FavoriteJokeUIInvent.ShowToast("Удалено"))
                updateState { it.copy(isLoading = false) }
            } catch (e: Exception) {
                updateState { it.copy(isLoading = false, isError = e.message ?: "Ошибка удаления") }
                updateUiEvent(FavoriteJokeUIInvent.ShowToast("Ошибка ${e.message}"))
            }
        }

    }

}