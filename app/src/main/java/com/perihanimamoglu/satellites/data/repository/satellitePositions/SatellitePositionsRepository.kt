package com.perihanimamoglu.satellites.data.repository.satellitePositions

import com.perihanimamoglu.satellites.data.remote.satellitePositions.response.SatellitePositionListResponse

interface SatellitePositionsRepository {

    suspend fun fetchSatellitePositions(): SatellitePositionListResponse?
}