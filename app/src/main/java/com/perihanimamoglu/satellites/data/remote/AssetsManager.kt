package com.perihanimamoglu.satellites.data.remote

import android.content.Context
import com.perihanimamoglu.satellites.core.readFile
import com.perihanimamoglu.satellites.data.remote.satellite.response.SatelliteResponse
import com.perihanimamoglu.satellites.data.remote.satelliteDetail.response.SatelliteDetailResponse
import com.perihanimamoglu.satellites.data.remote.satellitePositions.response.SatellitePositionListResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AssetsManager @Inject constructor(
    @ApplicationContext val context: Context, private val moshi: Moshi
) {

    fun fetchSatellites(): List<SatelliteResponse> {
        val type = Types.newParameterizedType(List::class.java, SatelliteResponse::class.java)
        val adapter: JsonAdapter<List<SatelliteResponse>> = moshi.adapter(type)
        val data = context.assets.readFile(SATELLITES_FILE_NAME)
        return adapter.fromJson(data) ?: listOf()
    }

    fun fetchSatelliteDetail(): List<SatelliteDetailResponse> {
        val type = Types.newParameterizedType(List::class.java, SatelliteDetailResponse::class.java)
        val adapter: JsonAdapter<List<SatelliteDetailResponse>> = moshi.adapter(type)
        val data = context.assets.readFile(SATELLITE_DETAIL_FILE_NAME)
        return adapter.fromJson(data) ?: listOf()
    }

    fun fetchSatellitePositions(): SatellitePositionListResponse? {
        val type = Types.newParameterizedType(SatellitePositionListResponse::class.java)
        val adapter: JsonAdapter<SatellitePositionListResponse> = moshi.adapter(type)
        val data = context.assets.readFile(POSITIONS_FILE_NAME)
        return adapter.fromJson(data)
    }

    companion object {
        private const val SATELLITES_FILE_NAME = "satellite-list.json"
        private const val SATELLITE_DETAIL_FILE_NAME = "satellite-detail.json"
        private const val POSITIONS_FILE_NAME = "positions.json"
    }
}