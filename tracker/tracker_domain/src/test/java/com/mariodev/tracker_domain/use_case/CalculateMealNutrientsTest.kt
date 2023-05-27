package com.mariodev.tracker_domain.use_case

import com.google.common.truth.Truth.assertThat
import com.mariodev.core.domain.model.ActivityLevel
import com.mariodev.core.domain.model.Gender
import com.mariodev.core.domain.model.GoalType
import com.mariodev.core.domain.model.UserInfo
import com.mariodev.core.domain.preferences.Preferences
import com.mariodev.tracker_domain.model.MealType
import com.mariodev.tracker_domain.model.Trackedfood
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.random.Random

class CalculateMealNutrientsTest {

    private lateinit var calculateMealNutrients: CalculateMealNutrients

    @Before
    fun setUp() {
        val preferences = mockk<Preferences>(relaxed = true)
        every {
            preferences.loadUserInfo()
        } returns UserInfo(
            gender = Gender.Male,
            age = 20,
            weight = 80f,
            height = 180,
            activityLevel = ActivityLevel.Medium,
            goalType = GoalType.KeepWeight,
            carbRatio = 0.4f,
            proteinRatio = 0.3f,
            fatRatio = 0.3f
        )
        calculateMealNutrients = CalculateMealNutrients(preferences)
    }

    @Test
    fun `Calories for breakfast properly calculated`() {
        val trackedFoods = (1..30).map {
            Trackedfood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf(
                        "breakfast",
                        "lunch",
                        "dinner",
                        "snack"
                    ).random()
                ),
                imageUrl = null,
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)

            )
        }

        val result = calculateMealNutrients(trackedFoods)

        val breakfastCalories =
            result.mealNutrients.values.filter { it.mealType is MealType.Breakfast }
                .sumOf { it.calories }
        val expectedCalories =
            trackedFoods.filter { it.mealType is MealType.Breakfast }
                .sumOf { it.calories }


        assertThat(breakfastCalories).isEqualTo(expectedCalories)

    }
}