package com.kromer.presentation.extensions

import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat

fun Resources.getColorResource(resourceId: Int) =
    ResourcesCompat.getColor(this, resourceId, null)