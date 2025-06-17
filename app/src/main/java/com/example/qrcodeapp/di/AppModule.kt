package com.example.qrcodeapp.di

import android.content.Context
import com.example.qrcodeapp.data.CounterRepositoryImpl
import com.example.qrcodeapp.data.api.JokeApiService
import com.example.qrcodeapp.data.api.KtorClientProvider
import com.example.qrcodeapp.domain.repository.CounterRepository
import com.example.qrcodeapp.domain.usecase.GetCounterUseCase
import com.example.qrcodeapp.domain.usecase.UpdateCounterUseCase
import com.example.qrcodeapp.domain.repository.JokeRepository
import com.example.qrcodeapp.domain.repository.JokeRepositoryImpl
import com.example.qrcodeapp.domain.usecase.GetRandomJokeUseCase
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

    @Provides
    @Singleton
    fun provideJokeApiService(): JokeApiService = JokeApiService(KtorClientProvider.client)

    @Provides
    @Singleton
    fun provideJokeRepository(apiService: JokeApiService): JokeRepository =
        JokeRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideGetRandomJokeUseCase(repository: JokeRepository): GetRandomJokeUseCase =
        GetRandomJokeUseCase(repository)
}