package com.perihanimamoglu.satellites.data.remote.satellitePositions

import com.perihanimamoglu.satellites.data.remote.AssetsManager
import com.perihanimamoglu.satellites.data.remote.satellitePositions.response.SatellitePositionListResponse
import javax.inject.Inject

class SatellitePositionsRemoteDataSource @Inject constructor(private val assetsManager: AssetsManager) {

    fun fetchSatellitePositions(): SatellitePositionListResponse? =
        assetsManager.fetchSatellitePositions()
}