package com.example.qrcodeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.qrcodeapp.ui.CounterScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as App).appComponent
        val viewModel = CounterViewModel(
            appComponent.provideGetCounterUseCase(),
            appComponent.provideUpdateCounterUseCase()
        )

        appComponent.inject(viewModel)

        setContent {
            CounterScreen(viewModel)
        }
    }
}