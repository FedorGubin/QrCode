package com.example.qrcodeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val _counter = MutableLiveData(0)
    var counter: LiveData<Int> = _counter

    fun increment() {
        _counter.value = (_counter.value ?: 0) + 1
    }
}