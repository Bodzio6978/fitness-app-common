package com.gmail.bogumilmecel2.util.extensions

fun String.isLengthInRange(maximum: Int, minimum: Int = 1): Boolean = length in minimum..maximum