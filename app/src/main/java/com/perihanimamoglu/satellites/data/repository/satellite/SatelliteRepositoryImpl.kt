package com.perihanimamoglu.satellites.data.repository.satellite

import com.perihanimamoglu.satellites.data.remote.satellite.SatelliteRemoteDataSource
import javax.inject.Inject

class SatelliteRepositoryImpl
@Inject constructor(private val satelliteRemoteDataSource: SatelliteRemoteDataSource) :
    SatelliteRepository {

    override fun fetchSatellites() = satelliteRemoteDataSource.fetchSatellites()
}