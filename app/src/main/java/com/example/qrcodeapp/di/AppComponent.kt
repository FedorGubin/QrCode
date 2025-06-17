package com.example.qrcodeapp.di

import com.example.qrcodeapp.ui.counter.CounterViewModel
import com.example.qrcodeapp.domain.usecase.GetCounterUseCase
import com.example.qrcodeapp.domain.usecase.UpdateCounterUseCase
import com.example.qrcodeapp.domain.usecase.GetRandomJokeUseCase
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(viewModel: CounterViewModel)
    fun provideGetCounterUseCase(): GetCounterUseCase
    fun provideUpdateCounterUseCase(): UpdateCounterUseCase
    fun provideGetRandomJokeUseCase(): GetRandomJokeUseCase
}