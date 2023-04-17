package com.perihanimamoglu.satellites.data.remote.satellitePositions.response

data class SatellitePositionResponse(
    val id: String?,
    val positions: List<SatellitePositionDetailResponse?>?
)