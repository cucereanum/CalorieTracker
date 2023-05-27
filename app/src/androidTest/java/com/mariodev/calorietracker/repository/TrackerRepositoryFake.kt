package com.mariodev.calorietracker.repository

import com.mariodev.tracker_domain.model.TrackableFood
import com.mariodev.tracker_domain.model.Trackedfood
import com.mariodev.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import java.time.LocalDate
import kotlin.random.Random

class TrackerRepositoryFake : TrackerRepository {

    var shouldReturnError = false


    private val trackedFood = mutableListOf<Trackedfood>()
    var searchResults = listOf<TrackableFood>()

    private val getFoodsForDateFlow = MutableSharedFlow<List<Trackedfood>>(replay = 1)

    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
      return if(shouldReturnError) {
           Result.failure(Throwable())
       } else {
           Result.success(searchResults)
      }
    }

    override suspend fun insertTrackedFood(food: Trackedfood) {
        trackedFood.add(food.copy(id = Random.nextInt()))
        getFoodsForDateFlow.emit(trackedFood)
    }

    override suspend fun deleteTrackedFood(food: Trackedfood) {
        trackedFood.remove(food)
        getFoodsForDateFlow.emit(trackedFood)
    }

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<Trackedfood>> {
            return getFoodsForDateFlow
    }
}