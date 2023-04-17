package com.perihanimamoglu.satellites.data.repository.satelliteDetail

import com.perihanimamoglu.satellites.data.local.SatelliteDetailEntity
import com.perihanimamoglu.satellites.data.local.SatelliteDetailLocalDataSource
import com.perihanimamoglu.satellites.data.remote.satelliteDetail.SatelliteDetailRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SatelliteDetailRepositoryImpl
@Inject constructor(
    private val satelliteDetailRemoteDataSource: SatelliteDetailRemoteDataSource,
    private val satelliteDetailLocalDataSource: SatelliteDetailLocalDataSource
) : SatelliteDetailRepository {

    override fun fetchSatelliteDetail() = satelliteDetailRemoteDataSource.fetchSatelliteDetail()

    override suspend fun fetchSatelliteDetail(id: Int): SatelliteDetailEntity? =
        satelliteDetailLocalDataSource.fetchSatelliteDetail(id = id)

    override suspend fun insertSatelliteDetail(satelliteDetailEntity: SatelliteDetailEntity) =
        satelliteDetailLocalDataSource.insertSatelliteDetail(satelliteDetailEntity)
}