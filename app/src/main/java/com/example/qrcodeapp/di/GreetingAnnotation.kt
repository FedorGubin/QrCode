package com.example.qrcodeapp.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FirstGreeting

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SecondGreeting
