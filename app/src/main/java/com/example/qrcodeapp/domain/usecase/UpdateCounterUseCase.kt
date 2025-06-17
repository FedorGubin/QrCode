package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.domain.repository.CounterRepository

class UpdateCounterUseCase(val repository: CounterRepository) {
    fun execute(newValue: Int): Int = repository.updateCounter(newValue)
}