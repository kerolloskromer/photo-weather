package com.kromer.photoweather.di.features.weather

import android.content.Context
import com.kromer.data.features.weather.datasource.remote.WeatherApiInterface
import com.kromer.data.features.weather.datasource.remote.WeatherRemoteDataSource
import com.kromer.data.features.weather.datasource.remote.WeatherRemoteDataSourceImpl
import com.kromer.data.features.weather.mappers.WeatherMapper
import com.kromer.data.features.weather.repository.WeatherRepositoryImpl
import com.kromer.domain.features.weather.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideWeatherApiInterface(retrofit: Retrofit): WeatherApiInterface =
        retrofit.create(WeatherApiInterface::class.java)

    @Provides
    @Singleton
    fun provideWeatherRemoteDataSource(
        apiInterface: WeatherApiInterface,
    ): WeatherRemoteDataSource = WeatherRemoteDataSourceImpl(apiInterface)

    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherRemoteDataSource: WeatherRemoteDataSource,
        weatherMapper: WeatherMapper,
    ): WeatherRepository = WeatherRepositoryImpl(weatherRemoteDataSource, weatherMapper)

    @Provides
    @Singleton
    fun provideWeatherMapper(
        @ApplicationContext context: Context,
    ): WeatherMapper = WeatherMapper(context)
}
