package com.example.registrationsdk.domain.use_cases

import com.example.registrationsdk.data.db.UserInfo
import com.example.registrationsdk.domain.datasource.UserInfoLocalDS
import javax.inject.Inject

class AddUserInfoUseCase  @Inject constructor(
    private val userInfoLocalDS: UserInfoLocalDS
) {
    suspend fun execute(userInfo: UserInfo) = userInfoLocalDS.insertUserInfo(userInfo)
}