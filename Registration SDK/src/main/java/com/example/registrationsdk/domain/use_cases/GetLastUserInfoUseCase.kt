package com.example.registrationsdk.domain.use_cases

import com.example.registrationsdk.domain.datasource.UserInfoLocalDS
import javax.inject.Inject

class GetLastUserInfoUseCase @Inject constructor(
    private val userInfoLocalDS: UserInfoLocalDS
) {
    suspend fun execute() = userInfoLocalDS.getLastItem()
}