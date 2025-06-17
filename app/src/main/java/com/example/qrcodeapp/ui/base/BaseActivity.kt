package com.example.qrcodeapp.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.qrcodeapp.App
import com.example.qrcodeapp.ui.MainActivity
import javax.inject.Inject

abstract class BaseActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        performInjection()
        super.onCreate(savedInstanceState)
    }

    private fun performInjection() {
        val appComponent = (application as App).appComponent

        when (this) {
            is MainActivity -> appComponent.inject(this)
            else -> throw IllegalArgumentException("Injection not implemented for ${this::class.java.simpleName}")
        }
    }
}