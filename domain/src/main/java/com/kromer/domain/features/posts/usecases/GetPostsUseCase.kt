package com.kromer.domain.features.posts.usecases

import com.kromer.domain.base.usecases.SuspendUseCase
import com.kromer.domain.features.posts.models.Post
import com.kromer.domain.features.posts.repository.PostsRepository
import com.kromer.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetPostsUseCase(
    private val repository: PostsRepository,
) : SuspendUseCase<Unit, Resource<Flow<List<Post>>>> {
    override suspend fun invoke(params: Unit): Resource<Flow<List<Post>>> = repository.getPosts()
}