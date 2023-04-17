package com.perihanimamoglu.satellites.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.perihanimamoglu.satellites.core.SatellitesDatabase.Companion.VERSION
import com.perihanimamoglu.satellites.data.local.SatelliteDetailDao
import com.perihanimamoglu.satellites.data.local.SatelliteDetailEntity

@Database(
    entities = [SatelliteDetailEntity::class], version = VERSION, exportSchema = false
)
abstract class SatellitesDatabase : RoomDatabase() {

    abstract fun getSatelliteDetailDao(): SatelliteDetailDao

    companion object {
        const val VERSION = 1
        const val DB_NAME = "SatellitesDatabase.db"
    }
}