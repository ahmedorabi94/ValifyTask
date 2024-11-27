package com.example.valifytask.di

import android.app.Application
import androidx.room.Room
import com.example.valifytask.data.db.AppDatabase
import com.example.valifytask.data.db.UserInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDatabase {

        return Room.databaseBuilder(app, AppDatabase::class.java, "users.db")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun provideUserInfoDao(db: AppDatabase): UserInfoDao {
        return db.userInfoDao()
    }
}