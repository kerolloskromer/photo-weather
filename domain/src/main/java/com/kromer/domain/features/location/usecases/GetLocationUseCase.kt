package com.kromer.domain.features.location.usecases

import com.kromer.domain.base.usecases.SuspendUseCase
import com.kromer.domain.features.location.models.Location
import com.kromer.domain.features.location.repository.LocationRepository
import com.kromer.domain.utils.Resource

class GetLocationUseCase(
    private val repository: LocationRepository
) : SuspendUseCase<Unit, Resource<Location?>> {
    override suspend fun invoke(params: Unit): Resource<Location?> = repository.getLocation()
}