package com.gmail.bogumilmecel2.diary.domain.model.recipe

import com.gmail.bogumilmecel2.common.domain.model.MeasurementUnit
import com.gmail.bogumilmecel2.diary.domain.model.common.NutritionValues
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    @SerialName("weight")
    val weight: Int,

    @SerialName("product_name")
    val productName: String,

    @SerialName("nutrition_values")
    val nutritionValues: NutritionValues,

    @SerialName("product_id")
    val productId: String,

    @SerialName("measurement_unit")
    val measurementUnit: MeasurementUnit,
)