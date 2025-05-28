package com.example.qrcodeapp

import android.app.Application
import com.example.qrcodeapp.di.AppComponent
import com.example.qrcodeapp.di.DaggerAppComponent
import com.example.qrcodeapp.di.modules.AppModule

class QrCodeApplication : Application() {

    private var _appComponent: AppComponent? = null // приватная var перемнная. Что бы нельзя было изменять ее вне класса
    val appComponent: AppComponent get() = _appComponent!! // доступная вне класса переменная. Явно не nullable. Мы знаем, что она уже сущестует

    override fun onCreate() {
        super.onCreate()

        // создали даггер компоненет. Класс сгенерировался на основе AppComponent. Используется паттерн билдер (что то настраиваем на станке и метод build = запуск станка)
        _appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(application = this)) // из-за того, что AppModule имеет не пустой конструктор - его необходимо создавать в ручную! (например NetworkModule с пустым конструктором и даггер его создаёт сам)
            .build()
    }
}