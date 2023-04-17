package com.perihanimamoglu.satellites.domain.satelliteDetail

import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import com.perihanimamoglu.satellites.domain.satelliteDetail.data.SatelliteDetail
import kotlinx.coroutines.flow.Flow

interface SatelliteDetailUseCase {

    fun fetchSatelliteDetail(item: Satellite): Flow<SatelliteDetail>

    suspend fun fetchLocalSatelliteDetail(item: Satellite): Flow<SatelliteDetail?>

    suspend fun insertSatelliteDetail(item: SatelliteDetail)
}