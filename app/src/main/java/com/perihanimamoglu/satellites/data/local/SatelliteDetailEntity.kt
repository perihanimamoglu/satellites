package com.perihanimamoglu.satellites.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "satelliteDetail")
data class SatelliteDetailEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "costPerLaunch") val costPerLaunch: String,
    @ColumnInfo(name = "firstFlight") val firstFlight: String,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "mass") val mass: Long,
    @ColumnInfo(name = "name") val name: String
)