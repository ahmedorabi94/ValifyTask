package com.example.registrationsdk.di

import com.example.registrationsdk.domain.datasource.UserInfoLocalDS
import com.example.registrationsdk.data.repo.UserInfoLocalDSImpl
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