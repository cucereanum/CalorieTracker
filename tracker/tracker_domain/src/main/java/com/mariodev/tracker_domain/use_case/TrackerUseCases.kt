package com.mariodev.tracker_domain.use_case

data class TrackerUseCases(
    val trackFood: TrackFood,
    val searchFood: SearchFood,
    val getFoodsForDate: GetFoodsForDate,
    val calculateMealNutrients: CalculateMealNutrients,
    val deleteTrackedFood: DeleteTrackedFood
)
