package com.example.qrcodeapp.ui.Joke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrcodeapp.domain.usecase.GetRandomJokeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokeViewModel @Inject constructor(
    private val getRandomJokeUseCase: GetRandomJokeUseCase
): ViewModel() {
    private val _state = MutableStateFlow(JokeViewState())
    val state: StateFlow<JokeViewState> = _state


    private fun loadJoke() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)

            try {
                val joke = getRandomJokeUseCase.execute()
                _state.value = JokeViewState(
                    isLoading = false,
                    jokeText = joke.text
                )
            } catch (e: Exception) {
                _state.value = JokeViewState(
                    isLoading = false,
                    error = "Ошибка: ${e.message}"
                )
            }
        }
    }
}