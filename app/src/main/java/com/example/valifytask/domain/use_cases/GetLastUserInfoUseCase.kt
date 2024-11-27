package com.example.valifytask.domain.use_cases

import com.example.valifytask.domain.datasource.UserInfoLocalDS
import javax.inject.Inject

class GetLastUserInfoUseCase @Inject constructor(
    private val userInfoLocalDS: UserInfoLocalDS
) {
    suspend fun execute() = userInfoLocalDS.getLastItem()
}