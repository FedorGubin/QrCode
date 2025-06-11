package com.example.qrcodeapp.ui

sealed class CounterViewIntent {
    data object Increment : CounterViewIntent()
    data object Decrement : CounterViewIntent()
}