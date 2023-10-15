package com.gmail.bogumilmecel2

class TestUseCase {
    operator fun invoke(
        returnError: Boolean,
        onSuccess: () -> Unit,
        onError: () -> Unit,
    ) {
        if (returnError) {
            onError()
        } else {
            onSuccess()
        }
    }
}