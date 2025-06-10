package com.example.qrcodeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.qrcodeapp.di.ErrorMessage
import com.example.qrcodeapp.di.FirstGreeting
import com.example.qrcodeapp.di.SecondGreeting
import com.example.qrcodeapp.di.WelcomeMessage
import com.example.qrcodeapp.ui.theme.QRCodeAppTheme
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var pingApiService: PingApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as QrCodeApplication).appComponent.inject(activity = this)

        lifecycleScope.launch {
            val result = pingApiService.ping()
            println("Ping result: $result")
        }

        setContent {
            QRCodeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text("Ping test started...")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QRCodeAppTheme {
        Greeting("Android")
    }
}