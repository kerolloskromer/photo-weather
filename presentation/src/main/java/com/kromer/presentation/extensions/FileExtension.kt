package com.kromer.presentation.extensions

import android.content.Context
import com.kromer.presentation.utils.FileUtils
import java.io.File

fun String.getUriForFilePath(context: Context) =
    FileUtils.getUriForFile(context, File(this))