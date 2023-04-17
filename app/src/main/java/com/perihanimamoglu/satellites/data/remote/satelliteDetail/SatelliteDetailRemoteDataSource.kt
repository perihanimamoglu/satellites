package com.perihanimamoglu.satellites.data.remote.satelliteDetail

import com.perihanimamoglu.satellites.data.remote.AssetsManager
import com.perihanimamoglu.satellites.data.remote.satelliteDetail.response.SatelliteDetailResponse
import javax.inject.Inject

class SatelliteDetailRemoteDataSource @Inject constructor(private val assetsManager: AssetsManager) {

    fun fetchSatelliteDetail(): List<SatelliteDetailResponse> = assetsManager.fetchSatelliteDetail()
}