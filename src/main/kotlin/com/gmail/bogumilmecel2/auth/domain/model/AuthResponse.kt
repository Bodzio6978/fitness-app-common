package com.gmail.bogumilmecel2.auth.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    @SerialName("token")
    val token:String
)
