package com.perihanimamoglu.satellites.data.local

import javax.inject.Inject

class SatelliteDetailLocalDataSource @Inject constructor(
    private val satelliteDetailDao: SatelliteDetailDao
) {

    suspend fun insertSatelliteDetail(satelliteDetailEntity: SatelliteDetailEntity) {
        satelliteDetailDao.insertSatelliteDetail(satelliteDetailEntity = satelliteDetailEntity)
    }

    suspend fun fetchSatelliteDetail(id: Int): SatelliteDetailEntity? =
        satelliteDetailDao.fetchSatelliteDetail(id)
}