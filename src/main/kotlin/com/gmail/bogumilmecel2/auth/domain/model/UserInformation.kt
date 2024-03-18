package com.gmail.bogumilmecel2.auth.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInformation (
    @SerialName("activity_level")
    val activityLevel: ActivityLevel? = null,

    @SerialName("type_of_work")
    val typeOfWork: TypeOfWork? = null,

    @SerialName("training_frequency")
    val trainingFrequency: TrainingFrequency? = null,

    @SerialName("gender")
    val gender: Gender? = null,

    @SerialName("height")
    val height: Int? = null,

    @SerialName("current_weight")
    val currentWeight: Double? = null,

    @SerialName("desired_weight")
    val desiredWeight: DesiredWeight? = null,

    @SerialName("age")
    val age: Int? = null,
)