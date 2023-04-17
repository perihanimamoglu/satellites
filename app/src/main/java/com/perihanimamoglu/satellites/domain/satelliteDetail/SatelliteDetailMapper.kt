package com.perihanimamoglu.satellites.domain.satelliteDetail

import com.perihanimamoglu.satellites.core.convertToDate
import com.perihanimamoglu.satellites.core.convertToString
import com.perihanimamoglu.satellites.core.orZero
import com.perihanimamoglu.satellites.data.remote.satelliteDetail.response.SatelliteDetailResponse
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import com.perihanimamoglu.satellites.domain.satelliteDetail.data.SatelliteDetail
import javax.inject.Inject

class SatelliteDetailMapper @Inject constructor() {

    fun mapOnSatelliteDetailResponse(
        satelliteDetailResponse: SatelliteDetailResponse, item: Satellite
    ): SatelliteDetail {
        return SatelliteDetail(
            id = satelliteDetailResponse.id.orZero(),
            cost_per_launch = mapOnCost(satelliteDetailResponse.cost_per_launch.orZero()),
            first_flight = satelliteDetailResponse.first_flight?.convertToDate()?.convertToString()
                .orEmpty(),
            height = satelliteDetailResponse.height.orZero(),
            mass = satelliteDetailResponse.mass.orZero(),
            name = mapOnName(satelliteDetailResponse, item)
        )
    }

    private fun mapOnName(
        satelliteDetailResponse: SatelliteDetailResponse, item: Satellite
    ): String = if (satelliteDetailResponse.id == item.id) item.name else ""

    private fun mapOnCost(cost: Long): String {
        val reverseCostList = cost.toString().trim().toMutableList().asReversed()
        val decimalCostList = mutableListOf<String>()

        reverseCostList.forEachIndexed { index, item ->
            if (index != 0 && index % 3 == 0) {
                decimalCostList.add(".")
            }
            decimalCostList.add(item.toString())
        }

        return decimalCostList.asReversed().joinToString("")
    }
}