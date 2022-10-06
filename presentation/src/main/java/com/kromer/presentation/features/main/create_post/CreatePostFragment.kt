package com.kromer.presentation.features.main.create_post

import android.Manifest
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import coil.load
import com.kromer.domain.features.weather.models.Weather
import com.kromer.domain.utils.Status
import com.kromer.presentation.R
import com.kromer.presentation.base.BaseFragment
import com.kromer.presentation.databinding.FragmentCreatePostBinding
import com.kromer.presentation.extensions.show
import com.kromer.presentation.extensions.showSnackBar
import com.kromer.presentation.features.camera.Camera
import com.kromer.presentation.utils.FileUtils
import dagger.hilt.android.AndroidEntryPoint
import java.io.File


@AndroidEntryPoint
class CreatePostFragment : BaseFragment<FragmentCreatePostBinding>() {

    private val viewModel: CreatePostViewModel by viewModels()

    private val permissions = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
    )

    private val permReqLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val granted = permissions.entries.all { it.value }
            if (granted) {
                openCamera()
            } else {
                binding.root.showSnackBar(
                    message = getString(R.string.permissions_error),
                    actionName = getString(R.string.ok),
                    action = {
                        findNavController().popBackStack()
                    }
                )
            }
        }

    private val cameraResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            getWeather(Camera.getResult())
        }

    override fun getVBInflater(): (LayoutInflater) -> FragmentCreatePostBinding =
        FragmentCreatePostBinding::inflate

    override fun setupViews() {
        setupOptionsMenu()
        showLoading(true)
        requestPermissions()
    }

    private fun setupOptionsMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_create_post, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_done -> {
                        save()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.STARTED)
    }

    private fun requestPermissions() {
        permReqLauncher.launch(permissions)
    }

    private fun openCamera() {
        Camera.dispatchTakePictureIntent(this, cameraResultLauncher)
    }

    private fun getWeather(photoPath: String?) {
        viewModel.getWeather().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {
                    showLoading(true)
                }
                Status.SUCCESS -> {
                    showLoading(false)
                    it.data?.let { weather ->
                        setData(photoPath, weather)
                    }
                }
                Status.ERROR -> {
                    showLoading(false)
                }
            }
        }
    }

    private fun setData(photoPath: String?, weather: Weather) {
        binding.ivImage.load(photoPath?.toUri())
        binding.tvAddress.text = weather.address
        binding.tvTemperature.text = getString(R.string.degree_celsius, weather.temp)
        binding.tvDescription.text = weather.description
    }

    private fun save() {
        val file = FileUtils.saveViewAsFile(binding.layoutPost, requireActivity().window)
        addPost(file)
    }

    private fun addPost(photoFile: File) {
        viewModel.addPost(photoFile.absolutePath).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {
                    showLoading(true)
                }
                Status.SUCCESS -> {
                    showLoading(false)
                    it.data?.let {
                        findNavController().popBackStack()
                    }
                }
                Status.ERROR -> {
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(show: Boolean) {
        binding.progressBar.show(show)
        binding.layoutPost.show(show.not())
    }
}