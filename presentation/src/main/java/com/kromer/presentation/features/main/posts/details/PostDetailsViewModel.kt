package com.kromer.presentation.features.main.posts.details

import com.kromer.domain.features.posts.usecases.GetPostByIdUseCase
import com.kromer.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val getPostByIdUseCase: GetPostByIdUseCase,
) : BaseViewModel() {

    fun getPost(id: Long?) = invokeUseCase { getPostByIdUseCase(id) }
}