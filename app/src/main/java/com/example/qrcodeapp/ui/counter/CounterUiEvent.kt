package com.example.qrcodeapp.ui.counter

import com.example.qrcodeapp.ui.base.BaseUiEvent

sealed class CounterUiEvent : BaseUiEvent {
    data class ShowToast(val message: String): CounterUiEvent()
}