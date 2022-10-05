package com.kromer.data.features.location.mappers

import com.kromer.domain.base.mappers.ModelMapper
import com.kromer.domain.features.location.models.Location

class LocationMapper : ModelMapper<android.location.Location, Location> {
    override fun mapFrom(from: android.location.Location): Location {
        return Location(
            from.latitude,
            from.longitude,
        )
    }
}