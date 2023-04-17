package com.perihanimamoglu.satellites.data.repository.di

import com.perihanimamoglu.satellites.data.repository.satellite.SatelliteRepository
import com.perihanimamoglu.satellites.data.repository.satellite.SatelliteRepositoryImpl
import com.perihanimamoglu.satellites.data.repository.satelliteDetail.SatelliteDetailRepository
import com.perihanimamoglu.satellites.data.repository.satelliteDetail.SatelliteDetailRepositoryImpl
import com.perihanimamoglu.satellites.data.repository.satellitePositions.SatellitePositionsRepository
import com.perihanimamoglu.satellites.data.repository.satellitePositions.SatellitePositionsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSatelliteRepository(satelliteRepositoryImpl: SatelliteRepositoryImpl): SatelliteRepository

    @Singleton
    @Binds
    abstract fun bindSatelliteDetailRepository(satelliteDetailRepositoryImpl: SatelliteDetailRepositoryImpl): SatelliteDetailRepository

    @Singleton
    @Binds
    abstract fun bindSatellitePositionsRepository(satellitePositionsRepositoryImpl: SatellitePositionsRepositoryImpl): SatellitePositionsRepository
}