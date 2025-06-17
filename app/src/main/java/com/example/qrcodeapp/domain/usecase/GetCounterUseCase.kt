package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.domain.repository.CounterRepository

class GetCounterUseCase(val repository: CounterRepository) {
    fun execute(): Int = repository.getCounter()
}