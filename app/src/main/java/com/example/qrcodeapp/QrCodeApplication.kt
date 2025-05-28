package com.example.qrcodeapp

import android.app.Application
import com.example.qrcodeapp.di.AppComponent
import com.example.qrcodeapp.di.DaggerAppComponent
import com.example.qrcodeapp.di.modules.AppModule

class QrCodeApplication : Application() {

    private var _appComponent: AppComponent? = null
    val appComponent: AppComponent get() = _appComponent!!

    override fun onCreate() {
        super.onCreate()

        val appModule = AppModule(application = this)

        _appComponent = DaggerAppComponent.builder()
            .appModule(appModule)
            .build()
    }
}