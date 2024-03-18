package com.gmail.bogumilmecel2.auth.domain.model

import com.gmail.bogumilmecel2.util.Constants
import com.gmail.bogumilmecel2.util.extensions.isLengthInRange
import java.util.regex.Pattern

class ValidateAuthDataUseCase {
    operator fun invoke(
        username: String,
        email: String,
        password: String,
    ): Result {
        val initialResult = invoke(email = email, password = password)

        if (initialResult != Result.Success) return initialResult

        if (username.isEmpty()) return Result.EmptyFields

        if (!username.isLengthInRange(
                minimum = Constants.Authentication.USERNAME_MIN_LENGTH,
                maximum = Constants.Authentication.USERNAME_MAX_LENGTH
            )
        ) return Result.UsernameLengthInvalid

        return Result.Success
    }

    operator fun invoke(
        email: String,
        password: String,
    ): Result {
        if (email.isEmpty() || password.isEmpty()) return Result.EmptyFields

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

        if (!Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches()) return Result.InvalidEmail

        return Result.Success
    }

    enum class Result {
        EmptyFields,
        PasswordLengthInvalid,
        UsernameLengthInvalid,
        EmailLengthInvalid,
        InvalidEmail,
        Success
    }
}