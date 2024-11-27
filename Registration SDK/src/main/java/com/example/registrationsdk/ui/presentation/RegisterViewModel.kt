package com.example.registrationsdk.ui.presentation

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registrationsdk.data.db.UserInfo
import com.example.registrationsdk.domain.use_cases.AddUserInfoUseCase
import com.example.registrationsdk.domain.use_cases.GetLastUserInfoUseCase
import com.example.registrationsdk.domain.use_cases.UpdateUserInfoUseCase
import com.example.registrationsdk.domain.validation.RegisterScreenState
import com.example.registrationsdk.domain.validation.ValidateEmail
import com.example.registrationsdk.domain.validation.ValidatePassword
import com.example.registrationsdk.domain.validation.ValidatePhone
import com.example.registrationsdk.domain.validation.ValidateUserName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val addUserInfoUseCase: AddUserInfoUseCase,
    private val updateUserInfoUseCase: UpdateUserInfoUseCase,
    private val getLastUserInfoUseCase: GetLastUserInfoUseCase,
) : ViewModel() {


    var state = RegisterScreenState()

    private val validatePassword = ValidatePassword()
    private val validateUserName: ValidateUserName = ValidateUserName()
    private val validateEmail = ValidateEmail()
    private val validatePhone = ValidatePhone()

    var closeApp = MutableStateFlow(false)

    fun saveData(): Boolean {

        val usernameResult = validateUserName.execute(state.userName)
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val phoneResult = validatePhone.execute(state.phoneNumber)


        state = state.copy(
            userNameError = usernameResult.errorMessage,
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            phoneNumberError = phoneResult.errorMessage,
        )

        return listOf(
            usernameResult,
            emailResult,
            phoneResult,
            passwordResult
        ).any { !it.successful }


    }

    fun addUserInfo() {
        viewModelScope.launch {
            val userInfo = UserInfo(
                userName = state.userName,
                email = state.email,
                phoneNumber = state.phoneNumber
            )
            addUserInfoUseCase.execute(userInfo)
        }

    }

    private fun saveImage(image: ByteArray) {
        viewModelScope.launch {
            val lastItem = getLastUserInfoUseCase.execute()
            val userItem = lastItem.copy(image = image)
            Timber.e("userItem $userItem")

            val id = updateUserInfoUseCase.execute(userItem)
            Timber.e("update id $id")
            closeApp.value = true
        }

    }


    fun bitmapToByteArray(bitmap: Bitmap) {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        saveImage(stream.toByteArray())
    }

}