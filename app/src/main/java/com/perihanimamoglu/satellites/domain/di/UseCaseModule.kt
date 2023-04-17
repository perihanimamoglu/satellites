package com.perihanimamoglu.satellites.domain.di

import com.perihanimamoglu.satellites.domain.satellite.SatelliteUseCase
import com.perihanimamoglu.satellites.domain.satellite.SatelliteUseCaseImpl
import com.perihanimamoglu.satellites.domain.satelliteDetail.SatelliteDetailUseCase
import com.perihanimamoglu.satellites.domain.satelliteDetail.SatelliteDetailUseCaseImpl
import com.perihanimamoglu.satellites.domain.satellitePositions.SatellitePositionsUseCase
import com.perihanimamoglu.satellites.domain.satellitePositions.SatellitePositionsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun bindSatelliteUseCase(satelliteUseCaseImpl: SatelliteUseCaseImpl): SatelliteUseCase

    @Singleton
    @Binds
    abstract fun bindSatelliteDetailUseCase(satelliteDetailUseCaseImpl: SatelliteDetailUseCaseImpl): SatelliteDetailUseCase

    @Singleton
    @Binds
    abstract fun binSatellitePositionsUseCaseImpl(satellitePositionsUseCaseImpl: SatellitePositionsUseCaseImpl): SatellitePositionsUseCase
}