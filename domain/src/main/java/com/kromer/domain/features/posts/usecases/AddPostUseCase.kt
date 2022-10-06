package com.kromer.domain.features.posts.usecases

import com.kromer.domain.base.usecases.SuspendUseCase
import com.kromer.domain.features.posts.models.Post
import com.kromer.domain.features.posts.repository.PostsRepository
import com.kromer.domain.utils.Resource

class AddPostUseCase(
    private val repository: PostsRepository,
) : SuspendUseCase<Post, Resource<Unit>> {
    override suspend fun invoke(params: Post): Resource<Unit> = repository.addPost(params)
}