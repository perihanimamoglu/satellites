package com.perihanimamoglu.satellites.domain.satellite

import com.perihanimamoglu.satellites.core.orFalse
import com.perihanimamoglu.satellites.core.orZero
import com.perihanimamoglu.satellites.data.remote.satellite.response.SatelliteResponse
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import javax.inject.Inject

class SatelliteMapper @Inject constructor() {

    fun mapOnSatellitesResponse(satellitesResponse: List<SatelliteResponse>): List<Satellite> {
        return satellitesResponse.map { satelliteResponse ->
            mapOnSatelliteResponse(satelliteResponse = satelliteResponse)
        }
    }

    private fun mapOnSatelliteResponse(satelliteResponse: SatelliteResponse): Satellite {
        return Satellite(
            id = satelliteResponse.id.orZero(),
            active = satelliteResponse.active.orFalse(),
            name = satelliteResponse.name.orEmpty()
        )
    }
}