package com.example.valifytask.use_cases

import com.example.valifytask.domain.UserInfoLocalDS
import javax.inject.Inject

class GetLastUserInfoUseCase @Inject constructor(
    private val userInfoLocalDS: UserInfoLocalDS
) {
    suspend fun execute() = userInfoLocalDS.getLastItem()
}