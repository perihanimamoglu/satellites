package com.perihanimamoglu.satellites.data.repository.di

import com.perihanimamoglu.satellites.data.repository.satellite.SatelliteRepository
import com.perihanimamoglu.satellites.data.repository.satellite.SatelliteRepositoryImpl
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
}