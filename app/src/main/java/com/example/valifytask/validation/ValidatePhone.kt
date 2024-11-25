package com.example.valifytask.validation


class ValidatePhone {
    fun execute(name: String): ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(
                successful = false,
                    errorMessage = "The phone field is required!"
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}