package com.perihanimamoglu.satellites.domain.satellite

import com.perihanimamoglu.satellites.data.repository.satellite.SatelliteRepository
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SatelliteUseCaseImpl @Inject constructor(
    private val satelliteRepository: SatelliteRepository,
    private val satelliteMapper: SatelliteMapper
) : SatelliteUseCase {

    override fun fetchSatellites(): Flow<List<Satellite>> = flow {
        satelliteRepository.fetchSatellites()
            .also { emit(satelliteMapper.mapOnSatellitesResponse(it)) }
    }
}