package com.example.qrcodeapp.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<STATE : BaseState, UI_EVENT : BaseUiEvent, INTENT : BaseIntent>(
    initState: STATE
) : ViewModel() {

    protected val _state = MutableStateFlow<STATE>(value = initState)
    val state: StateFlow<STATE> = _state

    protected val _uiEvent = MutableSharedFlow<UI_EVENT>(replay = 1)
    val uiEvent: SharedFlow<UI_EVENT> = _uiEvent

    abstract fun onIntent(intent: INTENT)

    protected fun updateState(reduce: (STATE) -> STATE) {
        _state.update(reduce)
    }
}