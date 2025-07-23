package com.example.qrcodeapp.ui.joke

import com.example.qrcodeapp.ui.base.BaseUiEvent

sealed class JokeUiEvent : BaseUiEvent {
    data class ShowToast(val message: String): JokeUiEvent()
}