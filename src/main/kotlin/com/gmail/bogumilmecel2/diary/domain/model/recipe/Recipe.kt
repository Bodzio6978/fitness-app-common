package com.gmail.bogumilmecel2.diary.domain.model.recipe

import com.gmail.bogumilmecel2.diary.domain.model.common.NutritionValues
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    @SerialName("id")
    val id: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("ingredients")
    val ingredients: List<Ingredient>? = null,

    @SerialName("image_url")
    val imageUrl: String? = null,

    @SerialName("nutrition_values")
    val nutritionValues: NutritionValues? = null,

    @SerialName("time_required")
    val timeRequiredInMinutes: TimeRequiredInMinutes? = null,

    @SerialName("difficulty")
    val difficulty: Difficulty? = null,

    @SerialName("servings")
    val servings: Int? = null,

    @SerialName("is_public")
    val isPublic: Boolean = false,

    @SerialName("username")
    val username: String? = null,

    @SerialName("user_id")
    val userId: String? = null,

    @SerialName("creation_date")
    val creationDateTime: LocalDateTime? = null
)