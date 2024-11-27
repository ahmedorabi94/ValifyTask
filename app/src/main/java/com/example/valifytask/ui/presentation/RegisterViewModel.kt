package com.example.valifytask.ui.presentation

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valifytask.data.db.UserInfo
import com.example.valifytask.domain.use_cases.AddUserInfoUseCase
import com.example.valifytask.domain.use_cases.GetLastUserInfoUseCase
import com.example.valifytask.domain.use_cases.UpdateUserInfoUseCase
import com.example.valifytask.domain.validation.RegisterScreenState
import com.example.valifytask.domain.validation.ValidateEmail
import com.example.valifytask.domain.validation.ValidatePassword
import com.example.valifytask.domain.validation.ValidatePhone
import com.example.valifytask.domain.validation.ValidateUserName
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
): ViewModel(){


    var state = RegisterScreenState()

   // var useInfo = UserInfo(userName = "", email = "",  phoneNumber = "")
    //val hasError = MutableStateFlow<Boolean>(false)


    private val validatePassword = ValidatePassword()
    private val validateUserName: ValidateUserName = ValidateUserName()
    private val validateEmail  = ValidateEmail()
    private val validatePhone = ValidatePhone()

    var closeApp = MutableStateFlow(false)
    //var navigateToCameraScreen = MutableStateFlow(false)

    fun resetData(){
     //   navigateToCameraScreen.value = false
        closeApp.value = false
    }

    fun saveData() : Boolean{

        val usernameResult = validateUserName.execute(state.userName)
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val phoneResult = validatePhone.execute(state.phoneNumber)


        state = state.copy(
            userNameError = usernameResult.errorMessage,
            emailError =  emailResult.errorMessage,
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

    fun addUserInfo(){
        viewModelScope.launch {
            val userInfo = UserInfo(userName = state.userName, email = state.email , phoneNumber = state.phoneNumber)
            addUserInfoUseCase.execute(userInfo)
           // navigateToCameraScreen.value = true
        }

    }

    private fun saveImage(image : ByteArray){
        viewModelScope.launch {
            val lastItem = getLastUserInfoUseCase.execute()
            Timber.e("lastItem $lastItem")
            val userItem = lastItem.copy(image = image)
            Timber.e("userItem $userItem")

           val id =  updateUserInfoUseCase.execute(userItem)
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