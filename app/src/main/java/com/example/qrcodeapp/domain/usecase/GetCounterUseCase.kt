package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.domain.repository.CounterRepository
import javax.inject.Inject

class GetCounterUseCase @Inject constructor(
    private val repository: CounterRepository
) {
    fun execute(): Int = repository.getCounter()
}