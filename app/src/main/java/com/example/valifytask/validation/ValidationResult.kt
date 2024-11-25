package com.example.valifytask.validation


data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)