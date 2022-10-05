package com.kromer.photoweather.di.features.location

import com.kromer.domain.features.location.repository.LocationRepository
import com.kromer.domain.features.location.usecases.GetLocationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetLocationUseCase(
        repository: LocationRepository
    ): GetLocationUseCase = GetLocationUseCase(repository)
}
