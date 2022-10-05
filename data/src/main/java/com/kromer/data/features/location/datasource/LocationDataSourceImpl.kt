package com.kromer.data.features.location.datasource

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Tasks


class LocationDataSourceImpl(
    private val context: Context,
) : LocationDataSource {

    // The Fused Location Provider provides access to location APIs.
    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }

    @SuppressLint("MissingPermission")
    override suspend fun getLocation(): Location? {
        val task = fusedLocationClient.lastLocation
        return Tasks.await(task)
    }
}