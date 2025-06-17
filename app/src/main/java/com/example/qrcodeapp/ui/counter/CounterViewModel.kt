package com.example.qrcodeapp.ui.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrcodeapp.domain.usecase.GetCounterUseCase
import com.example.qrcodeapp.domain.usecase.UpdateCounterUseCase
import com.example.qrcodeapp.ui.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CounterViewModel @Inject constructor(
    private val getCounterUseCase: GetCounterUseCase,
    private val updateCounterUseCase: UpdateCounterUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CounterViewState())
    val state: StateFlow<CounterViewState> = _state

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent

    init {
        loadInitialState()
    }

    private fun loadInitialState() {
        val current = getCounterUseCase.execute()
        _state.value = CounterViewState(count = current)
    }

    fun onIntent(intent: CounterViewIntent) {
        viewModelScope.launch {
            val current = getCounterUseCase.execute()
            val newValue = when (intent) {
                is CounterViewIntent.Increment -> current + 1
                is CounterViewIntent.Decrement -> current - 1
            }
            val update = updateCounterUseCase.execute(newValue)
            _state.value = CounterViewState(count = update)

            if (update == 10) {
                _uiEvent.emit(UiEvent.ShowToast("Достигнуто значение 10!"))
            }

            if (update == 20) {
                _uiEvent.emit(UiEvent.ShowToast("Достигнуто значение 20!"))
            }
        }
    }
}