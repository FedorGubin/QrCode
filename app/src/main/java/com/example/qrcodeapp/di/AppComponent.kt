package com.example.qrcodeapp.di

import com.example.qrcodeapp.MainActivity
import com.example.qrcodeapp.di.modules.AppModule
import com.example.qrcodeapp.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

// все модули должны быть добавлены в компонент
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(activity: MainActivity) // нужен по какой то странной логике работы даггера. Сюда добавляем активити, если хотим инжектить в  переменные внутри активити
}