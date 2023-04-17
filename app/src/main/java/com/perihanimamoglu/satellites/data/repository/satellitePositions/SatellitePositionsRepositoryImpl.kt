package com.perihanimamoglu.satellites.data.repository.satellitePositions

import com.perihanimamoglu.satellites.data.remote.satellitePositions.SatellitePositionsRemoteDataSource
import javax.inject.Inject

class SatellitePositionsRepositoryImpl
@Inject constructor(private val satellitePositionsRemoteDataSource: SatellitePositionsRemoteDataSource) :
    SatellitePositionsRepository {

    override suspend fun fetchSatellitePositions() =
        satellitePositionsRemoteDataSource.fetchSatellitePositions()
}