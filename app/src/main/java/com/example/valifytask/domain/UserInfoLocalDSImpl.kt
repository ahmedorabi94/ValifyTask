package com.example.valifytask.domain

import com.example.valifytask.db.UserInfo
import com.example.valifytask.db.UserInfoDao
import javax.inject.Inject

class UserInfoLocalDSImpl @Inject constructor(private val userInfoDao: UserInfoDao) :
    UserInfoLocalDS {
    override suspend fun insertAll(items: List<UserInfo>) {
        userInfoDao.insertItems(items)
    }

    override suspend fun insertUserInfo(userInfo: UserInfo) {
        userInfoDao.insertUserInfo(userInfo)
    }

    override fun getAllUsers(): List<UserInfo> {
        return userInfoDao.getAllItems()
    }

    override suspend fun updateUserInfo(userInfo: UserInfo): Int {
        return userInfoDao.updateUsername(userInfo)
    }

    override suspend fun deleteAllUsers() {
        userInfoDao.deleteAllItems()
    }

    override suspend fun getLastItem(): UserInfo {
        return userInfoDao.getLastItem()
    }


}