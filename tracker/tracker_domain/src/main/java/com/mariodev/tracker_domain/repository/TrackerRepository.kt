package com.mariodev.tracker_domain.repository

import com.mariodev.tracker_domain.model.TrackableFood
import com.mariodev.tracker_domain.model.Trackedfood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {

    suspend fun searchFood(query: String, page:Int, pageSize: Int) : Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: Trackedfood)

    suspend fun deleteTrackedFood(food: Trackedfood)

    fun getFoodsForDate(localDate: LocalDate): Flow<List<Trackedfood>>
}