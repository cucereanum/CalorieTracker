package com.mariodev.tracker_domain.use_case

import com.mariodev.tracker_domain.model.TrackableFood
import com.mariodev.tracker_domain.model.Trackedfood
import com.mariodev.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDate(
    private val repository: TrackerRepository
) {

     operator fun invoke(
        date: LocalDate
    ) : Flow<List<Trackedfood>> {
       return repository.getFoodsForDate(date)
    }
}