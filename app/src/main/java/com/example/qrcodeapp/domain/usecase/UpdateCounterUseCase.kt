package com.example.qrcodeapp.domain.usecase

import com.example.qrcodeapp.domain.repository.CounterRepository
import javax.inject.Inject

class UpdateCounterUseCase @Inject constructor(
    val repository: CounterRepository
) {
    fun execute(newValue: Int): Int = repository.updateCounter(newValue)
}