package com.perihanimamoglu.satellites.domain.satelliteDetail.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SatelliteDetail(
    val id: Int,
    val cost_per_launch: String,
    val first_flight: String,
    val height: Int,
    val mass: Long,
    val name: String
) : Parcelable