package com.example.qrcodeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.qrcodeapp.ui.counter.CounterScreen
import com.example.qrcodeapp.ui.joke.JokeScreen

@Composable
fun AppNav3(viewModelFactory: ViewModelProvider.Factory) {
    val backStack = rememberNavBackStack(CounterScreenKey)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<CounterScreenKey> {
                CounterScreen(
                    viewModelFactory = viewModelFactory,
                    onNavigateToJoke = { backStack.add(JokeScreenKey) }
                )
            }
            entry<JokeScreenKey> {
                JokeScreen(
                    viewModelFactory = viewModelFactory,
                    onBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}