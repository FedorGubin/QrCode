package com.example.qrcodeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.qrcodeapp.data.local.dao.FavoriteJokeDao
import com.example.qrcodeapp.data.local.entity.FavoriteJokeEntity

@Database(
    entities = [FavoriteJokeEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteJokeDao(): FavoriteJokeDao
}