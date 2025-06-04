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
import com.example.qrcodeapp.di.ErrorMessage
import com.example.qrcodeapp.di.FirstGreeting
import com.example.qrcodeapp.di.SecondGreeting
import com.example.qrcodeapp.di.WelcomeMessage
import com.example.qrcodeapp.ui.theme.QRCodeAppTheme
import javax.inject.Inject
import javax.inject.Named

class MainActivity : ComponentActivity() {

    @Inject
    @WelcomeMessage
    lateinit var welcome: String // нельзя, что бы переменная была приватная. И тут же используем фичу куалифаер
    @Inject
    @ErrorMessage
    lateinit var error: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as QrCodeApplication).appComponent.inject(activity = this)
        setContent {
            QRCodeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(error)
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