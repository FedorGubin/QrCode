package com.example.qrcodeapp.di

import android.content.Context
import com.example.qrcodeapp.data.repository.CounterRepositoryImpl
import com.example.qrcodeapp.data.api.JokeApiService
import com.example.qrcodeapp.data.local.dao.FavoriteJokeDao
import com.example.qrcodeapp.data.repository.FavoriteJokeRepositoryImpl
import com.example.qrcodeapp.domain.repository.CounterRepository
import com.example.qrcodeapp.domain.repository.JokeRepository
import com.example.qrcodeapp.data.repository.JokeRepositoryImpl
import com.example.qrcodeapp.domain.repository.FavoriteJokeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCounterRepository(context: Context): CounterRepository {
        return CounterRepositoryImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideJokeRepository(apiService: JokeApiService): JokeRepository {
        return JokeRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideFavoriteRepository(dao: FavoriteJokeDao) : FavoriteJokeRepository{
        return FavoriteJokeRepositoryImpl(dao)
    }
}