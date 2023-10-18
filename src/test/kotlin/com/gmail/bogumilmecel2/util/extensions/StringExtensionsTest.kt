package com.gmail.bogumilmecel2.util.extensions

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringExtensionsTest {

    @Test
    fun `Check if string length is not in range false is returned 1`() {
        assertFalse { callIsLengthInRange("abc") }
    }

    @Test
    fun `Check if string length is not in range false is returned 2`() {
        assertFalse { callIsLengthInRange("abcdef") }
    }

    @Test
    fun `Check if string length is in range false is returned 1`() {
        assertTrue { callIsLengthInRange("abcd") }
    }

    @Test
    fun `Check if string length is in range false is returned 2`() {
        assertTrue { callIsLengthInRange("abcde") }
    }

    private fun callIsLengthInRange(text: String) = text.isLengthInRange(
        minimum = 4,
        maximum = 5
    )
}