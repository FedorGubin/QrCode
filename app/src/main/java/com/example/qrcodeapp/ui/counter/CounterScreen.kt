package com.example.qrcodeapp.ui.counter

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(
    viewModelFactory: ViewModelProvider.Factory,
    onNavigateToJoke: () -> Unit
) {

    val viewModel = viewModel<CounterViewModel>(factory = viewModelFactory)
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is CounterUiEvent.ShowToast -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Счёт: ${state.count}", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Button(onClick = { viewModel.onIntent(CounterViewIntent.Decrement) }) {
                Text("-")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.onIntent(CounterViewIntent.Increment) }) {
                Text("+")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = onNavigateToJoke) {
                Text("Посмотреть шутку")
            }
        }
    }
}