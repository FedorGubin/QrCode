package com.example.qrcodeapp.data.repository

import android.content.Context
import androidx.core.content.edit
import com.example.qrcodeapp.domain.repository.CounterRepository

class CounterRepositoryImpl(context: Context): CounterRepository {
    private val prefs = context.getSharedPreferences("counter_prefs", Context.MODE_PRIVATE)

    override fun getCounter(): Int {
        return prefs.getInt(COUNTER_KEY, 0)
    }

    override fun updateCounter(value: Int): Int {
        prefs.edit { putInt(COUNTER_KEY, value) }
        return value
    }

    companion object {
        private const val COUNTER_KEY = "counter_key"
    }
}