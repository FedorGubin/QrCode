package com.example.qrcodeapp

import com.example.qrcodeapp.domain.CounterRepository

class CounterRepositoryImpl: CounterRepository {
    private var counter = 0
    override fun getCounter(): Int = counter

    override fun updateCounter(value: Int): Int {
        counter = value
        return counter
    }
}