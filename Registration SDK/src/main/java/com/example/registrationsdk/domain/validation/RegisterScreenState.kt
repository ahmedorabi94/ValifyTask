package com.example.registrationsdk.domain.validation

data class RegisterScreenState (
    val userName: String = "",
    val userNameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val phoneNumber: String = "",
    val phoneNumberError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
)