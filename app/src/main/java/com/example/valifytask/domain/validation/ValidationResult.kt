package com.example.valifytask.domain.validation


data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)