package com.example.qrcodeapp.ui.counter

import com.example.qrcodeapp.ui.base.BaseIntent

sealed class CounterViewIntent : BaseIntent {
    data object Increment : CounterViewIntent()
    data object Decrement : CounterViewIntent()
}