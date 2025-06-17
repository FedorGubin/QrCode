package com.example.qrcodeapp.ui.joke

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun JokeScreen(viewModelFactory: ViewModelProvider.Factory) {
    val viewModel = viewModel<JokeViewModel>(factory = viewModelFactory)
}