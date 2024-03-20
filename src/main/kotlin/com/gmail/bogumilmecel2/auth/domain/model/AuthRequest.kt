package com.gmail.bogumilmecel2.auth.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(
    @SerialName("username")
    val username: String? = null,

    @SerialName("email")
    val email: String? = null,

    @SerialName("password")
    val password: String? = null
)
