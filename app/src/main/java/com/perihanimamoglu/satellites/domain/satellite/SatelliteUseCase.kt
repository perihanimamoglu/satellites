package com.perihanimamoglu.satellites.domain.satellite

import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import kotlinx.coroutines.flow.Flow

interface SatelliteUseCase {

    fun fetchSatellites(): Flow<List<Satellite>>
}