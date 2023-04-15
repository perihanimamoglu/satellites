package com.perihanimamoglu.satellites.domain.di

import com.perihanimamoglu.satellites.domain.satellite.SatelliteUseCase
import com.perihanimamoglu.satellites.domain.satellite.SatelliteUseCaseImpl
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
}