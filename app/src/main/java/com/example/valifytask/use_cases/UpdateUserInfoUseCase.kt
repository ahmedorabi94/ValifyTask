package com.example.valifytask.use_cases

import com.example.valifytask.db.UserInfo
import com.example.valifytask.domain.UserInfoLocalDS
import javax.inject.Inject

class UpdateUserInfoUseCase @Inject constructor(
    private val userInfoLocalDS: UserInfoLocalDS
) {
    suspend fun execute(userInfo: UserInfo) = userInfoLocalDS.updateUserInfo(userInfo)
}