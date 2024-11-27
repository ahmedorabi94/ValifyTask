package com.example.registrationsdk.domain.validation


data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)