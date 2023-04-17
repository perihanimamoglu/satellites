package com.perihanimamoglu.satellites.domain.satelliteDetail

import com.perihanimamoglu.satellites.data.local.SatelliteDetailEntity
import com.perihanimamoglu.satellites.data.remote.satelliteDetail.response.SatelliteDetailResponse
import com.perihanimamoglu.satellites.data.repository.satelliteDetail.SatelliteDetailRepository
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import com.perihanimamoglu.satellites.domain.satelliteDetail.data.SatelliteDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class SatelliteDetailUseCaseImpl @Inject constructor(
    private val satelliteDetailRepository: SatelliteDetailRepository,
    private val satelliteDetailMapper: SatelliteDetailMapper
) : SatelliteDetailUseCase {

    override fun fetchSatelliteDetail(item: Satellite): Flow<SatelliteDetail> = flow {
        satelliteDetailRepository.fetchSatelliteDetail().also { satelliteDetails ->
            satelliteDetails.filter {
                it.id == item.id
            }.map {
                val satelliteDetail = satelliteDetailMapper.mapOnSatelliteDetailResponse(it, item)
                insertSatelliteDetail(satelliteDetail)
                emit(satelliteDetail)
            }
        }
    }

    override suspend fun fetchLocalSatelliteDetail(item: Satellite): Flow<SatelliteDetail?> = flow {
        satelliteDetailRepository.fetchSatelliteDetail(id = item.id).also { detailEntity ->
            if (detailEntity == null) {
                emit(null)
            } else {
                val satelliteDetail = SatelliteDetail(
                    id = detailEntity.id,
                    cost_per_launch = detailEntity.costPerLaunch,
                    first_flight = detailEntity.firstFlight,
                    height = detailEntity.height,
                    mass = detailEntity.mass,
                    name = detailEntity.name
                )
                emit(satelliteDetail)
            }
        }
    }

    override suspend fun insertSatelliteDetail(item: SatelliteDetail) {
        satelliteDetailRepository.insertSatelliteDetail(
            SatelliteDetailEntity(
                id = item.id,
                costPerLaunch = item.cost_per_launch,
                firstFlight = item.first_flight,
                height = item.height,
                mass = item.mass,
                name = item.name
            )
        )
    }
}