package com.example.qrcodeapp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.qrcodeapp.ui.counter.CounterScreen
import com.example.qrcodeapp.ui.joke.JokeDetailScreen
import com.example.qrcodeapp.ui.joke.JokeScreen

@Composable
fun AppNav3(viewModelFactory: ViewModelProvider.Factory) {
    val backStackFirstFlow = rememberNavBackStack<FirstStack>(CounterScreenKey)
    val backStackSecondFlow = rememberNavBackStack<SecondStack>(SecondScreen)
    val backStackThirdFlow = rememberNavBackStack<ThirdStack>(ThirdScreen)

    var currentStack = remember { mutableStateOf(backStackFirstFlow) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NavDisplay(
            modifier = Modifier.weight(1f),
            backStack = currentStack.value,
            onBack = { backStackFirstFlow.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<CounterScreenKey> {
                    CounterScreen(
                        viewModelFactory = viewModelFactory,
                        onNavigateToJoke = { backStackFirstFlow.add(JokeScreenKey) }
                    )
                }
                entry<JokeScreenKey> {
                    JokeScreen(
                        viewModelFactory = viewModelFactory,
                        onBack = { backStackFirstFlow.removeLastOrNull() },
                        onNavigateToDetail = { backStackFirstFlow.add(JokeDetailScreenKey(it)) }
                    )
                }
                entry<JokeDetailScreenKey> {
                    JokeDetailScreen(
                        jokeText = it.jokeText,
                        onBack = {
                            val counterIndex = backStackFirstFlow.lastIndexOf(CounterScreenKey)
                            if (counterIndex >= 0) {
                                backStackFirstFlow.removeRange(counterIndex + 1, backStackFirstFlow.size)
                            }
                        }
                    )
                }

                entry<SecondScreen> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Второй стэк экранов")
                    }
                }

                entry<ThirdScreen> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Третий стэк экранов")
                    }
                }
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(56.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    currentStack.value = backStackFirstFlow
                }
            ) {
                Text("First")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    currentStack.value = backStackSecondFlow
                }
            ) {
                Text("Second")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    currentStack.value = backStackThirdFlow
                }
            ) {
                Text("Third")
            }
        }
    }
}