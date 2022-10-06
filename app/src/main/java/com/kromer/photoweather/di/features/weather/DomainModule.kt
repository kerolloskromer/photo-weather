package com.kromer.photoweather.di.features.weather

import com.kromer.domain.features.location.usecases.GetLocationUseCase
import com.kromer.domain.features.weather.repository.WeatherRepository
import com.kromer.domain.features.weather.usecases.GetWeatherUseCase
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
    fun provideGetWeatherUseCase(
        repository: WeatherRepository,
        getLocationUseCase: GetLocationUseCase,
    ): GetWeatherUseCase = GetWeatherUseCase(repository, getLocationUseCase)
}
