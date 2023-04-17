package com.perihanimamoglu.satellites.data.repository.satelliteDetail

import com.perihanimamoglu.satellites.data.local.SatelliteDetailEntity
import com.perihanimamoglu.satellites.data.remote.satelliteDetail.response.SatelliteDetailResponse

interface SatelliteDetailRepository {

    fun fetchSatelliteDetail(): List<SatelliteDetailResponse>

    suspend fun insertSatelliteDetail(satelliteDetailEntity: SatelliteDetailEntity)

    suspend fun fetchSatelliteDetail(id: Int): SatelliteDetailEntity?
}