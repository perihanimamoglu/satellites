package com.perihanimamoglu.satellites.data.local

import androidx.room.*

@Dao
interface SatelliteDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSatelliteDetail(satelliteDetailEntity: SatelliteDetailEntity)

    @Query("SELECT * FROM satelliteDetail WHERE id=:id")
    suspend fun fetchSatelliteDetail(id: Int): SatelliteDetailEntity?
}