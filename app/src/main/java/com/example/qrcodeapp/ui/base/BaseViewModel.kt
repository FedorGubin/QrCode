package com.example.qrcodeapp.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<STATE : BaseState, UI_EVENT : BaseUiEvent, INTENT : BaseIntent>(
    initState: STATE
) : ViewModel() {

    private val _state = MutableStateFlow<STATE>(value = initState)
    val state: StateFlow<STATE> = _state

    private val _uiEvent = Channel<UI_EVENT>(Channel.BUFFERED)
    val uiEvent: Flow<UI_EVENT> = _uiEvent.receiveAsFlow()

    abstract fun onIntent(intent: INTENT)

    protected fun updateState(reduce: (STATE) -> STATE) {
        _state.update(reduce)
    }

    protected fun updateUiEvent(event: UI_EVENT) {
        _uiEvent.trySend(event)
    }
}