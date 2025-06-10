package com.example.qrcodeapp.domain

class GetCounterUseCase(val repository: CounterRepository) {
    fun execute(): Int = repository.getCounter()
}