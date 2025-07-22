package com.example.qrcodeapp.di

import android.content.Context
import androidx.room.Room
import com.example.qrcodeapp.data.local.AppDataBase
import com.example.qrcodeapp.data.local.dao.FavoriteJokeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun dataBaseProvides(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            "app_database"
            ).build()
    }
    @Provides
    fun provideFavoriteJokeDao(db: AppDataBase): FavoriteJokeDao{
        return db.favoriteJokeData()
    }
}