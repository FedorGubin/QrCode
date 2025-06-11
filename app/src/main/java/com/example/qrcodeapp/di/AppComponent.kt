package com.example.qrcodeapp.di

import com.example.qrcodeapp.CounterViewModel
import com.example.qrcodeapp.domain.GetCounterUseCase
import com.example.qrcodeapp.domain.UpdateCounterUseCase
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(viewModel: CounterViewModel)
    fun provideGetCounterUseCase(): GetCounterUseCase
    fun provideUpdateCounterUseCase(): UpdateCounterUseCase
}