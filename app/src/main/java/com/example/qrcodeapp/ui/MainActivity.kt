package com.example.qrcodeapp.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.qrcodeapp.domain.repository.JokeRepository
import com.example.qrcodeapp.ui.base.BaseActivity
import com.example.qrcodeapp.ui.counter.CounterScreen
import com.example.qrcodeapp.ui.joke.JokeScreen
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var api: JokeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val joke = api.getRandomJoke()
            Log.d("JokeTest", joke.text)
        }

        setContent {
            JokeScreen(viewModelFactory)
        }
    }
}