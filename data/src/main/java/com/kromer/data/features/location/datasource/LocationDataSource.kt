package com.kromer.data.features.location.datasource

import android.location.Location


interface LocationDataSource {
    suspend fun getLocation(): Location?
}