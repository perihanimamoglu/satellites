package com.perihanimamoglu.satellites.domain.satellitePositions

import com.perihanimamoglu.satellites.data.repository.satellitePositions.SatellitePositionsRepository
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePosition
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePositionDetail
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePositionList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SatellitePositionsUseCaseImpl @Inject constructor(
    private val satellitePositionsRepository: SatellitePositionsRepository,
    private val satellitePositionMapper: SatellitePositionMapper
) : SatellitePositionsUseCase {

    override fun fetchSatellitePositions(id: Int): Flow<SatellitePositionList> = flow {
        satellitePositionsRepository.fetchSatellitePositions().also {
            emit(satellitePositionMapper.mapOnSatellitePositionListResponse(it))
        }
    }

    override fun fetchSatellitePosition(
        satellitePositions: List<SatellitePosition>, id: Int
    ): Flow<SatellitePositionDetail> = flow {
        satellitePositions.forEach { satellitePosition ->
            if (satellitePosition.id == id) {
                satellitePosition.positions.forEach {
                    emit(it)
                    delay(3000)
                }
            }
        }
    }
}