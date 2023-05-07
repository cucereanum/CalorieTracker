package com.mariodev.calorietracker.navigation

import androidx.navigation.NavController
import com.mariodev.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}