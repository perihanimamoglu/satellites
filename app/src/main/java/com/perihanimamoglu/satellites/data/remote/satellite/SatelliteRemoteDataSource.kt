package com.perihanimamoglu.satellites.data.remote.satellite

import com.perihanimamoglu.satellites.data.remote.AssetsManager
import com.perihanimamoglu.satellites.data.remote.satellite.response.SatelliteResponse
import javax.inject.Inject

class SatelliteRemoteDataSource @Inject constructor(private val assetsManager: AssetsManager) {

    fun fetchSatellites(): List<SatelliteResponse> = assetsManager.fetchSatellites()
}