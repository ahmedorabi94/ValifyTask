package com.example.valifytask.validation


class ValidateUserName {

    fun execute(username: String): ValidationResult {
        if (username.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The userame can't be blank"
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}