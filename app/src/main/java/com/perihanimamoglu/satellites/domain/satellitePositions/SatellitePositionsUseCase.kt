package com.perihanimamoglu.satellites.domain.satellitePositions

import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePosition
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePositionDetail
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePositionList
import kotlinx.coroutines.flow.Flow

interface SatellitePositionsUseCase {

    fun fetchSatellitePositions(id: Int): Flow<SatellitePositionList>

    fun fetchSatellitePosition(
        satellitePositions: List<SatellitePosition>,
        id: Int
    ): Flow<SatellitePositionDetail>
}