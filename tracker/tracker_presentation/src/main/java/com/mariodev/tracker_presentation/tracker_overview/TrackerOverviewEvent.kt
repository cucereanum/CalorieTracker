package com.mariodev.tracker_presentation.tracker_overview

import com.mariodev.tracker_domain.model.Trackedfood

sealed class TrackerOverviewEvent {
    object OnNextDayClick: TrackerOverviewEvent()
    object OnPreviousDayClick: TrackerOverviewEvent()
    data class OnToogleMealClick(val meal: Meal) : TrackerOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: Trackedfood) : TrackerOverviewEvent()
}
