package com.gmail.bogumilmecel2.auth

import com.gmail.bogumilmecel2.util.Constants
import com.gmail.bogumilmecel2.util.extensions.isLengthInRange
import java.util.regex.Pattern

class ValidateRegisterDataUseCase {
    operator fun invoke(
        username: String,
        email: String,
        password: String,
    ): Result {
        if (!email.isLengthInRange(
                maximum = Constants.Authentication.EMAIL_MAX_LENGTH,
                minimum = Constants.Authentication.EMAIL_MIN_LENGTH
            )
        ) return Result.EmailLengthInvalid

        if (!password.isLengthInRange(
                minimum = Constants.Authentication.PASSWORD_MIN_LENGTH,
                maximum = Constants.Authentication.PASSWORD_MAX_LENGTH
            )
        ) return Result.PasswordLengthInvalid

        if (!username.isLengthInRange(
                minimum = Constants.Authentication.USERNAME_MIN_LENGTH,
                maximum = Constants.Authentication.USERNAME_MAX_LENGTH
            )
        ) return Result.UsernameLengthInvalid

        if (!Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches()) return Result.InvalidEmail

        return Result.Success
    }

    enum class Result {
        PasswordLengthInvalid,
        UsernameLengthInvalid,
        EmailLengthInvalid,
        InvalidEmail,
        Success
    }
}