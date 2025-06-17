package com.example.qrcodeapp.ui.counter

import com.example.qrcodeapp.domain.usecase.GetCounterUseCase
import com.example.qrcodeapp.domain.usecase.UpdateCounterUseCase
import com.example.qrcodeapp.ui.base.BaseViewModel
import javax.inject.Inject

class CounterViewModel @Inject constructor(
    getCounterUseCase: GetCounterUseCase,
    private val updateCounterUseCase: UpdateCounterUseCase
) : BaseViewModel<CounterViewState, CounterUiEvent, CounterViewIntent>(
    initState = CounterViewState(count = getCounterUseCase.execute())
) {

    override fun onIntent(intent: CounterViewIntent) {
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
            updateUiEvent(CounterUiEvent.ShowToast("Достигнуто значение 10!"))
        }

        if (newValue == 20) {
            updateUiEvent(CounterUiEvent.ShowToast("Достигнуто значение 20!"))
        }
    }
}