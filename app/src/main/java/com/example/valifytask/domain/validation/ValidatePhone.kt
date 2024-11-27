package com.example.valifytask.domain.validation

import java.util.regex.Pattern


class ValidatePhone {
    fun execute(phone: String): ValidationResult {
        if (phone.isBlank()) {
            return ValidationResult(
                successful = false,
                    errorMessage = "The phone field is required!"
            )
        }

        if (!isValidPhoneNumber(phone)) {
            return ValidationResult(
                successful = false,
                errorMessage = "That's not a valid phone"
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }


    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phoneNumberPattern = Pattern.compile("^\\+?[0-9]{10,15}\$")
        return phoneNumberPattern.matcher(phoneNumber).matches()
    }
}