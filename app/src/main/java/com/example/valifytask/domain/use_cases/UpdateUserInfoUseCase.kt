package com.example.valifytask.domain.use_cases

import com.example.valifytask.data.db.UserInfo
import com.example.valifytask.domain.datasource.UserInfoLocalDS
import javax.inject.Inject

class UpdateUserInfoUseCase @Inject constructor(
    private val userInfoLocalDS: UserInfoLocalDS
) {
    suspend fun execute(userInfo: UserInfo) = userInfoLocalDS.updateUserInfo(userInfo)
}