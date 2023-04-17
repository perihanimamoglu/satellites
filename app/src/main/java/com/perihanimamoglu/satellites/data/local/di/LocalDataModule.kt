package com.perihanimamoglu.satellites.data.local.di

import com.perihanimamoglu.satellites.core.SatellitesDatabase
import com.perihanimamoglu.satellites.data.local.SatelliteDetailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    fun provideMarketDao(
        satellitesDatabase: SatellitesDatabase
    ): SatelliteDetailDao = satellitesDatabase.getSatelliteDetailDao()
}