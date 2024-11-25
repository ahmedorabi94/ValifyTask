package com.example.valifytask.presentation

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valifytask.db.UserInfo
import com.example.valifytask.use_cases.AddUserInfoUseCase
import com.example.valifytask.use_cases.GetLastUserInfoUseCase
import com.example.valifytask.use_cases.UpdateUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val addUserInfoUseCase: AddUserInfoUseCase,
    private val updateUserInfoUseCase: UpdateUserInfoUseCase,
    private val getLastUserInfoUseCase: GetLastUserInfoUseCase
): ViewModel(){


    var useInfo = UserInfo(userName = "", email = "",  phoneNumber = "")


    fun addUserInfo(){
        viewModelScope.launch {
            addUserInfoUseCase.execute(useInfo)
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
        }

    }


    fun bitmapToByteArray(bitmap: Bitmap) {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        saveImage(stream.toByteArray())
    }

}