package com.example.qrcodeapp.di.modules

import android.app.Application
import android.content.Context
import com.example.qrcodeapp.di.FirstGreeting
import com.example.qrcodeapp.di.SecondGreeting
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    @FirstGreeting
    fun provideString(): String = "Privet"

    @Provides
    @SecondGreeting
    fun provideString2(): String = "Privet2"

    @Provides
    fun provideContext(): Context = application.applicationContext
}