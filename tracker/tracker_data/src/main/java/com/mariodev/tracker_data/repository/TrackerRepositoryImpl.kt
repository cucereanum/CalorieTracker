package com.mariodev.tracker_data.repository

import com.mariodev.tracker_data.local.TrackerDao
import com.mariodev.tracker_data.mapper.toTrackableFood
import com.mariodev.tracker_data.mapper.toTrackedFood
import com.mariodev.tracker_data.mapper.toTrackedFoodEntity
import com.mariodev.tracker_data.remote.OpenFoodApi
import com.mariodev.tracker_domain.model.TrackableFood
import com.mariodev.tracker_domain.model.Trackedfood
import com.mariodev.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class TrackerRepositoryImpl(
    private val dao: TrackerDao,
    private val api: OpenFoodApi
) : TrackerRepository {
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDto = api.searchFood(query, page, pageSize)

            Result.success(searchDto.products.mapNotNull {
                it.toTrackableFood()
            })
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(food: Trackedfood) {
        dao.insertTrackedFood(food.toTrackedFoodEntity())
    }

    override suspend fun deleteTrackedFood(food: Trackedfood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntity())
    }

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<Trackedfood>> {
        return dao.getFoodsForDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        ).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }
}