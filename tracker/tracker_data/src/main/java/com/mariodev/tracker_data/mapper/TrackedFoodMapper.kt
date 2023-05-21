package com.mariodev.tracker_data.mapper

import com.mariodev.tracker_data.local.entity.TrackedFoodEntity
import com.mariodev.tracker_domain.model.MealType
import com.mariodev.tracker_domain.model.Trackedfood
import java.time.LocalDate

fun TrackedFoodEntity.toTrackedFood(): Trackedfood {
    return Trackedfood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id,
    )
}

fun Trackedfood.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        type = mealType.name,
        amount = amount,
        dayOfMonth = date.dayOfMonth,
        month = date.monthValue,
        year = date.year,
        calories = calories,
        id = id
    )
}