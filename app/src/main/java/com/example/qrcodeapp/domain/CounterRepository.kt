package com.example.qrcodeapp.domain

interface CounterRepository {
    fun getCounter(): Int
    fun updateCounter(value: Int): Int
}