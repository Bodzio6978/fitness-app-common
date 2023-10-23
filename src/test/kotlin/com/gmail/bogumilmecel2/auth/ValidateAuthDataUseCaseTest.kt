package com.gmail.bogumilmecel2.auth

import com.gmail.bogumilmecel2.util.Constants
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidateAuthDataUseCaseTest {
    companion object {
        private const val INVALID_EMAIL = "email"
        private const val CORRECT_EMAIL = "email@email.com"
        private const val CORRECT_PASSWORD = "123456"
        private const val CORRECT_USERNAME = "username"
    }

    private val validateAuthDataUseCase = ValidateAuthDataUseCase()

    @Test
    fun `Check if email is empty, empty fields result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.EmptyFields,
            actual = callTestedMethod(
                email = ""
            ),
        )
    }

    @Test
    fun `Check if password is empty, empty fields result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.EmptyFields,
            actual = callTestedMethod(
                password = ""
            ),
        )
    }

    @Test
    fun `Check if username is empty, empty fields result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.EmptyFields,
            actual = callTestedMethod(
                username = ""
            ),
        )
    }

    @Test
    fun `Check if email is shorter than min length, email length invalid result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.EmailLengthInvalid,
            actual = callTestedMethod(
                email = createString(length = Constants.Authentication.EMAIL_MIN_LENGTH - 1)
            ),
        )
    }

    @Test
    fun `Check if email is longer than max length, email length invalid result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.EmailLengthInvalid,
            actual = callTestedMethod(
                email = createString(length = Constants.Authentication.EMAIL_MAX_LENGTH + 1)
            ),
        )
    }

    @Test
    fun `Check if password is shorter than min length, password length invalid result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.PasswordLengthInvalid,
            actual = callTestedMethod(
                password = createString(length = Constants.Authentication.PASSWORD_MIN_LENGTH - 1)
            ),
        )
    }

    @Test
    fun `Check if password is longer than max length, password length invalid result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.PasswordLengthInvalid,
            actual = callTestedMethod(
                password = createString(length = Constants.Authentication.PASSWORD_MAX_LENGTH + 1)
            ),
        )
    }

    @Test
    fun `Check if username is shorter than min length, username length invalid result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.UsernameLengthInvalid,
            actual = callTestedMethod(
                username = createString(length = Constants.Authentication.USERNAME_MIN_LENGTH - 1)
            ),
        )
    }

    @Test
    fun `Check if username is longer than max length, username length invalid result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.UsernameLengthInvalid,
            actual = callTestedMethod(
                username = createString(length = Constants.Authentication.USERNAME_MAX_LENGTH + 1)
            ),
        )
    }

    @Test
    fun `Check if email is invalid, invalid email result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.InvalidEmail,
            actual = callTestedMethod(email = INVALID_EMAIL),
        )
    }

    @Test
    fun `Check data is correct, success result is returned`() {
        assertEquals(
            expected = ValidateAuthDataUseCase.Result.Success,
            actual = callTestedMethod(),
        )
    }

    private fun createString(length: Int) = StringBuilder().apply {
        (1..length).map {
            append("a")
        }
    }.toString()

    private fun callTestedMethod(
        email: String = CORRECT_EMAIL,
        password: String = CORRECT_PASSWORD,
        username: String = CORRECT_USERNAME
    ) = validateAuthDataUseCase(
        email = email,
        password = password,
        username = username
    )
}