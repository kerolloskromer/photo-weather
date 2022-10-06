package com.kromer.domain.features.location.repository

import com.kromer.domain.features.location.models.Location
import com.kromer.domain.utils.Resource


interface LocationRepository {
    suspend fun getLocation(): Resource<Location?>
}