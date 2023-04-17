package com.perihanimamoglu.satellites.ui.satelliteDetail

import android.text.SpannableStringBuilder
import androidx.core.text.bold
import com.perihanimamoglu.satellites.core.orZero
import com.perihanimamoglu.satellites.domain.satelliteDetail.data.SatelliteDetail

class SatelliteDetailViewState(private val satelliteDetail: SatelliteDetail?) {

    fun getName() = satelliteDetail?.name

    fun getCost(): SpannableStringBuilder =
        SpannableStringBuilder().bold { append("Cost: ") }.append(satelliteDetail?.cost_per_launch)

    fun getFirstFlight() = satelliteDetail?.first_flight

    fun getHeightMass(): SpannableStringBuilder =
        SpannableStringBuilder().bold { append("Height/Mass: ") }
            .append(satelliteDetail?.height.toString() + "/" + satelliteDetail?.mass.toString())

    fun getId() = satelliteDetail?.id.orZero()
}