package com.example.qrcodeapp.ui.counter

sealed class CounterViewIntent {
    data object Increment : CounterViewIntent()
    data object Decrement : CounterViewIntent()
}