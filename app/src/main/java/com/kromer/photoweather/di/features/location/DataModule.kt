package com.kromer.photoweather.di.features.location

import android.content.Context
import com.kromer.data.features.location.datasource.LocationDataSource
import com.kromer.data.features.location.datasource.LocationDataSourceImpl
import com.kromer.data.features.location.mappers.LocationMapper
import com.kromer.data.features.location.repository.LocationRepositoryImpl
import com.kromer.domain.features.location.repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideLocationDataSource(
        @ApplicationContext context: Context,
    ): LocationDataSource =
        LocationDataSourceImpl(context)

    @Provides
    @Singleton
    fun provideLocationRepository(
        locationDataSource: LocationDataSource,
        locationMapper: LocationMapper,
    ): LocationRepository =
        LocationRepositoryImpl(locationDataSource, locationMapper)

    @Provides
    @Singleton
    fun provideLocationMapper(): LocationMapper = LocationMapper()
}
