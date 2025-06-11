package com.example.qrcodeapp.di

import android.content.Context
import com.example.qrcodeapp.data.CounterRepositoryImpl
import com.example.qrcodeapp.domain.CounterRepository
import com.example.qrcodeapp.domain.GetCounterUseCase
import com.example.qrcodeapp.domain.UpdateCounterUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideCounterRepository(): CounterRepository = CounterRepositoryImpl(context)

    @Provides
    fun provideGetCounterUseCase(repo: CounterRepository): GetCounterUseCase =
        GetCounterUseCase(repo)

    @Provides
    fun provideUpdateCounterUseCase(repo: CounterRepository): UpdateCounterUseCase =
        UpdateCounterUseCase(repo)
}