package com.example.valifytask.domain.datasource

import com.example.valifytask.data.db.UserInfo

interface UserInfoLocalDS {

    suspend fun insertAll(items: List<UserInfo>)
    suspend fun insertUserInfo(userInfo: UserInfo)
    fun getAllUsers(): List<UserInfo>
    suspend fun updateUserInfo(userInfo: UserInfo): Int
    suspend fun deleteAllUsers()
    suspend fun getLastItem(): UserInfo
}