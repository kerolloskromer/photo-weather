package com.kromer.presentation.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.kromer.presentation.R
import com.kromer.presentation.extensions.getUriForFilePath


object ShareUtils {

    fun share(context: Context, photoPath: String) {
        val uri: Uri = photoPath.getUriForFilePath(context)
        val intent = Intent(Intent.ACTION_SEND)
        // uri of image to share
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        // text to share
        intent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.share_text))
        // type to stream/file
        intent.type = "image/jpeg"
        context.startActivity(Intent.createChooser(intent, context.getString(R.string.share_via)))
    }
}