package com.example.qrcodeapp.ui.joke

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun JokeScreen(
    viewModelFactory: ViewModelProvider.Factory,
    onNavigateToJokeFavorite: () -> Unit,
    onBack: () -> Unit,
    onNavigateToDetail: (String) -> Unit,

) {
    val viewModel = viewModel<JokeViewModel>(factory = viewModelFactory)
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading) {
            Text("Загрузка шутки...")
        } else if (state.error != null) {
            Text("Ошибка: ${state.error}")
        } else {
            Text(state.jokeText ?: "Шутка не загружена")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            viewModel.onIntent(JokeViewIntent.LoadJoke)
        }) {
            Text("Показать шутку")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack) {
            Text("Назад к счётчику")
        }

        if (!state.jokeText.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                onNavigateToDetail(state.jokeText!!)
            }) {
                Text("Подробнее")
            }

        }
        Button(onClick = onNavigateToJokeFavorite) {
            Text("Избранные шутки")
        }
        Button(onClick = {
            viewModel.onIntent(JokeViewIntent.AddFavoriteJoke(jokeText = state.jokeText ?: ""))
        }) {
            Text("Избранное")
        }
    }
}
