package com.example.qrcodeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.qrcodeapp.data.api.JokeApiService
import com.example.qrcodeapp.data.api.KtorClientProvider
import com.example.qrcodeapp.ui.CounterScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as App).appComponent
        val viewModel = CounterViewModel(
            appComponent.provideGetCounterUseCase(),
            appComponent.provideUpdateCounterUseCase()
        )
        val api = JokeApiService(KtorClientProvider.client)

        lifecycleScope.launch {
            val joke = api.getRandomJoke()
            Log.d("JokeTest", joke.text)
        }

        appComponent.inject(viewModel)

        setContent {
            CounterScreen(viewModel)
        }
    }
}