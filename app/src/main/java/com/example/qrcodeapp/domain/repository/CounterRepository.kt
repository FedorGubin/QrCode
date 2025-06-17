package com.example.qrcodeapp.domain.repository

interface CounterRepository {
    fun getCounter(): Int
    fun updateCounter(value: Int): Int
}