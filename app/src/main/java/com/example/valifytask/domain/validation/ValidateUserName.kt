package com.example.valifytask.domain.validation


class ValidateUserName {

    fun execute(username: String): ValidationResult {
        if (username.isBlank()  || username.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "The userame can't be blank and less than 8 characters"
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}