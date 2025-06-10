package com.example.qrcodeapp.domain

import androidx.camera.core.imagecapture.JpegBytes2Disk.In

class UpdateCounterUseCase(val repository: CounterRepository) {
    fun execute(newValue: Int): Int = repository.updateCounter(newValue)
}