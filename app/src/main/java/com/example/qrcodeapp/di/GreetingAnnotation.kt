package com.example.qrcodeapp.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FirstGreeting

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SecondGreeting

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class WelcomeMessage

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ErrorMessage
