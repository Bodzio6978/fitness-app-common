package com.gmail.bogumilmecel2.diary.domain.model.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
enum class TimeRequiredInMinutes {
    @SerialName("fifteen")
    FIFTEEN,

    @SerialName("thirty")
    THIRTY,

    @SerialName("forty_five")
    FORTY_FIVE,

    @SerialName("more")
    MORE;
}