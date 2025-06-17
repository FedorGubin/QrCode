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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class CounterViewModel @Inject constructor(
    getCounterUseCase: GetCounterUseCase,
    private val updateCounterUseCase: UpdateCounterUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<CounterViewState>(
        CounterViewState(count = getCounterUseCase.execute())
    )
    val state: StateFlow<CounterViewState> = _state

    private val _uiEvent = MutableSharedFlow<UiEvent>(replay = 1).apply {
        tryEmit(UiEvent.ShowToast("show"))
    }
    val uiEvent: SharedFlow<UiEvent> = _uiEvent

    fun onIntent(intent: CounterViewIntent) {
        when (intent) {
            CounterViewIntent.Decrement -> decrement()
            CounterViewIntent.Increment -> increment()
        }
    }

    private fun decrement() {
        updateState {
            val newValue = it.count - 1
            updateCounterUseCase.execute(newValue)
            showToast(newValue)
            it.copy(count = newValue)
        }
    }

    private fun increment() {
        updateState {
            val newValue = it.count + 1
            updateCounterUseCase.execute(newValue)
            showToast(newValue)
            it.copy(count = newValue)
        }
    }

    private fun showToast(newValue: Int) {
        if (newValue == 10) {
            _uiEvent.tryEmit(UiEvent.ShowToast("Достигнуто значение 10!"))
        }

        if (newValue == 20) {
            _uiEvent.tryEmit(UiEvent.ShowToast("Достигнуто значение 20!"))
        }
    }

    private fun updateState(reduce: (CounterViewState) -> CounterViewState) {
        _state.update(reduce)
    }
}