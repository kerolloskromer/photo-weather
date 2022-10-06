package com.kromer.presentation.features.main.posts

import com.kromer.domain.features.posts.usecases.GetPostsUseCase
import com.kromer.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
) : BaseViewModel() {

    fun getPosts() = invokeUseCase { getPostsUseCase(Unit) }
}