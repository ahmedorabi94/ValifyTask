package com.example.valifytask.di

import com.example.valifytask.domain.UserInfoLocalDS
import com.example.valifytask.domain.UserInfoLocalDSImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun providesUserInfoLocalDataSourceImpl(userInfoLocalDataSource: UserInfoLocalDSImpl): UserInfoLocalDS =
        userInfoLocalDataSource

}