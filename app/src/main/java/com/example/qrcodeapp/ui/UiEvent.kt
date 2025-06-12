package com.example.qrcodeapp.ui

sealed class UiEvent {
    data class ShowToast(val message: String): UiEvent()
}