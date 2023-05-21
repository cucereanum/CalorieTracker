package com.mariodev.tracker_domain.use_case

import com.mariodev.tracker_domain.model.TrackableFood
import com.mariodev.tracker_domain.model.Trackedfood
import com.mariodev.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        trackedFood: Trackedfood
    ) {
       return repository.deleteTrackedFood(trackedFood)
    }
}