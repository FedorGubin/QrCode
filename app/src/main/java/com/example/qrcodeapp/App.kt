package com.example.qrcodeapp

import android.app.Application
import com.example.qrcodeapp.di.AppComponent
import com.example.qrcodeapp.di.AppModule
import com.example.qrcodeapp.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }
}