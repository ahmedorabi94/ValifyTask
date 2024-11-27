package com.example.valifytask.domain.validation


class ValidatePassword {
    fun execute(password: String): ValidationResult {
        if (password.length < 6) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to consist of at least 6 characters"
            )
        }
        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}