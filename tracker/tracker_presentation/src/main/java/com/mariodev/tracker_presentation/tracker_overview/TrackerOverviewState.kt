package com.mariodev.tracker_presentation.tracker_overview

import com.mariodev.tracker_domain.model.Trackedfood
import java.time.LocalDate

data class TrackerOverviewState(
    val totalCarbs: Int = 0,
    val totalProtein: Int = 0,
    val totalFat: Int = 0,
    val totalCalories: Int = 0,
    val carbsGoal: Int = 0,
    val proteinGoal: Int = 0,
    val fatGoal: Int = 0,
    val caloriesGoal: Int = 0,
    val date: LocalDate = LocalDate.now(),
    val trackedFoods: List<Trackedfood> = emptyList(),
val meals: List<Meal> = emptyList()
)
