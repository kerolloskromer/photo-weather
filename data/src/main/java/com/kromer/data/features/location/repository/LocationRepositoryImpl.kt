package com.kromer.data.features.location.repository

import com.kromer.data.base.BaseRepositoryImpl
import com.kromer.data.features.location.datasource.LocationDataSource
import com.kromer.data.features.location.mappers.LocationMapper
import com.kromer.domain.base.mappers.mapFromWith
import com.kromer.domain.features.location.models.Location
import com.kromer.domain.features.location.repository.LocationRepository
import com.kromer.domain.utils.Resource

class LocationRepositoryImpl(
    private val locationDataSource: LocationDataSource,
    private val locationMapper: LocationMapper,
) : LocationRepository, BaseRepositoryImpl() {

    override suspend fun getLocation(): Resource<Location?> =
        safeCall { locationDataSource.getLocation()?.mapFromWith(locationMapper) }
}