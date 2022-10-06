package com.kromer.domain.features.posts.usecases

import com.kromer.domain.base.usecases.SuspendUseCase
import com.kromer.domain.features.posts.models.Post
import com.kromer.domain.features.posts.repository.PostsRepository
import com.kromer.domain.utils.Resource

class GetPostByIdUseCase(
    private val repository: PostsRepository,
) : SuspendUseCase<Long?, Resource<Post?>> {
    override suspend fun invoke(params: Long?): Resource<Post?> = repository.getById(params)
}