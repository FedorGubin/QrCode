package com.example.qrcodeapp.di

import com.example.qrcodeapp.MainActivity
import com.example.qrcodeapp.ui.counter.CounterViewModel
import com.example.qrcodeapp.domain.usecase.GetCounterUseCase
import com.example.qrcodeapp.domain.usecase.UpdateCounterUseCase
import com.example.qrcodeapp.domain.usecase.GetRandomJokeUseCase
import com.example.qrcodeapp.ui.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    AppModule::class,
    ViewModelModule::class,
    RepositoryModule::class,
    NetworkModule::class
])
@Singleton
interface AppComponent {
    fun inject(activity: BaseActivity)
    fun provideGetRandomJokeUseCase(): GetRandomJokeUseCase
}