package com.example.qrcodeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.qrcodeapp.ui.base.BaseActivity
import com.example.qrcodeapp.ui.counter.CounterScreen

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val api = JokeApiService(KtorClientProvider.client)
//
//        lifecycleScope.launch {
//            val joke = api.getRandomJoke()
//            Log.d("JokeTest", joke.text)
//        }

        setContent {
            CounterScreen(viewModelFactory)
        }
    }
}