package com.gmail.bogumilmecel2.auth.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Gender {
    @SerialName("male")
    MALE,

    @SerialName("female")
    FEMALE;
}

@Serializable
enum class TypeOfWork {
    @SerialName("sedentary")
    SEDENTARY,

    @SerialName("mixed")
    MIXED,

    @SerialName("physical")
    PHYSICAL;
}

@Serializable
enum class TrainingFrequency {
    @SerialName("none")
    NONE,

    @SerialName("low")
    LOW,

    @SerialName("average")
    AVERAGE,

    @SerialName("high")
    HIGH,

    @SerialName("very_high")
    VERY_HIGH;
}

@Serializable
enum class ActivityLevel {
    @SerialName("low")
    LOW,

    @SerialName("moderate")
    MODERATE,

    @SerialName("high")
    HIGH,

    @SerialName("very_high")
    VERY_HIGH;
}

@Serializable
enum class DesiredWeight {
    @SerialName("loose")
    LOOSE,

    @SerialName("keep")
    KEEP,

    @SerialName("gain")
    GAIN;
}