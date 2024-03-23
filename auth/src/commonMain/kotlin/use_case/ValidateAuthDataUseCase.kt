package use_case

import util.AuthConstants
import util.extensions.isLengthInRange

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
                minimum = AuthConstants.Authentication.USERNAME_MIN_LENGTH,
                maximum = AuthConstants.Authentication.USERNAME_MAX_LENGTH
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
                maximum = AuthConstants.Authentication.EMAIL_MAX_LENGTH,
                minimum = AuthConstants.Authentication.EMAIL_MIN_LENGTH
            )
        ) return Result.EmailLengthInvalid

        if (!password.isLengthInRange(
                minimum = AuthConstants.Authentication.PASSWORD_MIN_LENGTH,
                maximum = AuthConstants.Authentication.PASSWORD_MAX_LENGTH
            )
        ) return Result.PasswordLengthInvalid

        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()
        if (!email.matches(emailRegex)) return Result.InvalidEmail

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