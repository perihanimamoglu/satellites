package com.perihanimamoglu.satellites.data.remote.satelliteDetail.response

data class SatelliteDetailResponse(
    val id: Int?,
    val cost_per_launch: Long?,
    val first_flight: String?,
    val height: Int?,
    val mass: Long?
)