package com.example.qrcodeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qrcodeapp.domain.GetCounterUseCase
import com.example.qrcodeapp.domain.UpdateCounterUseCase
import com.example.qrcodeapp.ui.CounterViewIntent
import com.example.qrcodeapp.ui.CounterViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class CounterViewModel @Inject constructor(
    private val getCounterUseCase: GetCounterUseCase,
    private val updateCounterUseCase: UpdateCounterUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CounterViewState())
    val state: StateFlow<CounterViewState> = _state

    init {
        loadInitialState()
    }

    private fun loadInitialState() {
        val current = getCounterUseCase.execute()
        _state.value = CounterViewState(count = current)
    }

    fun onIntent(intent: CounterViewIntent) {
        val current = getCounterUseCase.execute()
        val newValue = when (intent) {
            is CounterViewIntent.Increment -> current +1
            is CounterViewIntent.Decrement -> current -1
        }
        val update = updateCounterUseCase.execute(newValue)
        _state.value = CounterViewState(count = update)
    }
}