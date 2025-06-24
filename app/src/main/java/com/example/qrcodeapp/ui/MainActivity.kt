package com.example.qrcodeapp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.qrcodeapp.ui.base.BaseActivity
import com.example.qrcodeapp.ui.navigation.AppNav3

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           AppNav3(viewModelFactory)
        }
    }
}