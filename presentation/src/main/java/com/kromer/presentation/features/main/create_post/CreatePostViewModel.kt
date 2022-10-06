package com.kromer.presentation.features.main.create_post

import com.kromer.domain.features.posts.models.Post
import com.kromer.domain.features.posts.usecases.AddPostUseCase
import com.kromer.domain.features.weather.usecases.GetWeatherUseCase
import com.kromer.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CreatePostViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val addPostUseCase: AddPostUseCase,
) : BaseViewModel() {

    fun getWeather() = invokeUseCase { getWeatherUseCase(Unit) }

    fun addPost(originalPhotoPath: String, photoPath: String) =
        invokeUseCase { addPostUseCase(Post(0, originalPhotoPath, photoPath)) }
}