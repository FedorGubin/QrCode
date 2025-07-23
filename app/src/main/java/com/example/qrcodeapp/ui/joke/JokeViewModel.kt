package com.example.qrcodeapp.ui.joke

import androidx.lifecycle.viewModelScope
import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity
import com.example.qrcodeapp.domain.usecase.AddFavoriteJokeUseCase
import com.example.qrcodeapp.domain.usecase.GetRandomJokeUseCase
import com.example.qrcodeapp.ui.base.BaseViewModel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokeViewModel @Inject constructor(
    private val getRandomJokeUseCase: GetRandomJokeUseCase,
    private val addFavoriteJokeUseCase: AddFavoriteJokeUseCase
) : BaseViewModel<JokeViewState, JokeUiEvent, JokeViewIntent>(
    JokeViewState()
) {
    init {
        loadJoke()
    }

    private fun loadJoke() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val joke = getRandomJokeUseCase.execute()
                updateState {
                    it.copy(
                        isLoading = false,
                        jokeText = joke.text
                    )
                }
            } catch (e: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = "Ошибка: ${e.message}"
                    )
                }
            }
        }
    }

    private fun addFavoriteJoke(jokeText: String) {
        viewModelScope.launch {
            try {
                val joke = FavoriteJokeEntity(jokeText = jokeText)
                addFavoriteJokeUseCase.execute(joke)
                updateUiEvent(JokeUiEvent.ShowToast("Добавлено в избранное"))
            } catch (e: Exception) {
                updateUiEvent(JokeUiEvent.ShowToast("Ошибка добавления ${e.message}"))
            }
        }
    }

    override fun onIntent(intent: JokeViewIntent) {
        when (intent) {
            is JokeViewIntent.LoadJoke -> {
                loadJoke()
            }
            is JokeViewIntent.AddFavoriteJoke -> addFavoriteJoke(intent.jokeText)
        }
    }
}