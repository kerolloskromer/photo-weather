package com.kromer.presentation.utils

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import java.io.IOException


object CameraUtils {
    private var currentPhotoPath: String = ""

    fun dispatchTakePictureIntent(
        fragment: Fragment,
        cameraResultLauncher: ActivityResultLauncher<Intent>,
    ) {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            try {
                // Create the File where the photo should go
                val photoFile = try {
                    FileUtils.createImageFile(fragment.requireContext())
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileUtils.getUriForFile(
                        fragment.requireContext(),
                        it
                    )
                    currentPhotoPath = it.absolutePath
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    cameraResultLauncher.launch(takePictureIntent)
                }
            } catch (e: ActivityNotFoundException) {
            }
        }
    }

    fun getResult(): String = currentPhotoPath
}