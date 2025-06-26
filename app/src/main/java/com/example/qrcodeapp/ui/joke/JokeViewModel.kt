package com.example.qrcodeapp.ui.joke

import androidx.lifecycle.viewModelScope
import com.example.qrcodeapp.domain.usecase.GetRandomJokeUseCase
import com.example.qrcodeapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokeViewModel @Inject constructor(
    private val getRandomJokeUseCase: GetRandomJokeUseCase
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

    override fun onIntent(intent: JokeViewIntent) {
        when (intent) {
            is JokeViewIntent.LoadJoke -> {
                loadJoke()
            }
        }
    }
}