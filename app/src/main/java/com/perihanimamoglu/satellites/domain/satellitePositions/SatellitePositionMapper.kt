package com.perihanimamoglu.satellites.domain.satellitePositions

import com.perihanimamoglu.satellites.core.orZero
import com.perihanimamoglu.satellites.data.remote.satellitePositions.response.SatellitePositionDetailResponse
import com.perihanimamoglu.satellites.data.remote.satellitePositions.response.SatellitePositionListResponse
import com.perihanimamoglu.satellites.data.remote.satellitePositions.response.SatellitePositionResponse
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePosition
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePositionDetail
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePositionList
import javax.inject.Inject

class SatellitePositionMapper @Inject constructor() {

    fun mapOnSatellitePositionListResponse(satellitePositionListResponse: SatellitePositionListResponse?): SatellitePositionList {
        return SatellitePositionList(
            list = mapOnSatellitePositionsResponse(
                satellitePositionListResponse?.list
            )
        )
    }

    private fun mapOnSatellitePositionsResponse(satellitePositionsResponse: List<SatellitePositionResponse?>?): List<SatellitePosition> {
        return satellitePositionsResponse?.map {
            mapOnSatellitePositionResponse(it)
        } ?: listOf()
    }

    private fun mapOnSatellitePositionResponse(satellitePositionResponse: SatellitePositionResponse?): SatellitePosition {
        return SatellitePosition(
            id = satellitePositionResponse?.id?.toInt().orZero(),
            positions = mapOnSatellitePositionDetailsResponse(satellitePositionResponse?.positions)
        )
    }

    private fun mapOnSatellitePositionDetailsResponse(
        satellitePositionDetailsResponse: List<SatellitePositionDetailResponse?>?
    ): List<SatellitePositionDetail> {
        return satellitePositionDetailsResponse?.map {
            mapOnSatellitePositionDetailResponse(it)
        } ?: listOf()
    }

    private fun mapOnSatellitePositionDetailResponse(
        satellitePositionDetailResponse: SatellitePositionDetailResponse?
    ): SatellitePositionDetail {
        return SatellitePositionDetail(
            posX = satellitePositionDetailResponse?.posX.orZero(),
            posY = satellitePositionDetailResponse?.posY.orZero()
        )
    }
}