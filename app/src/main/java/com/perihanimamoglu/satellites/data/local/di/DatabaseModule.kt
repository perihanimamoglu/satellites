package com.perihanimamoglu.satellites.data.local.di

import android.content.Context
import androidx.room.Room
import com.perihanimamoglu.satellites.core.SatellitesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideSatellitesDatabase(@ApplicationContext context: Context): SatellitesDatabase =
        Room.databaseBuilder(context, SatellitesDatabase::class.java, SatellitesDatabase.DB_NAME)
            .build()
}