package com.example.qrcodeapp.di

import com.example.qrcodeapp.MainActivity
import com.example.qrcodeapp.di.modules.AppModule
import com.example.qrcodeapp.di.modules.NetworkModule
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
}