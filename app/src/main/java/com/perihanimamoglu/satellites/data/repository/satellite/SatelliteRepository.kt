package com.perihanimamoglu.satellites.data.repository.satellite

import com.perihanimamoglu.satellites.data.remote.satellite.response.SatelliteResponse

interface SatelliteRepository {

    fun fetchSatellites(): List<SatelliteResponse>
}