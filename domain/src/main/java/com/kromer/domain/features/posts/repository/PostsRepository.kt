package com.kromer.domain.features.posts.repository

import com.kromer.domain.features.posts.models.Post
import com.kromer.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    suspend fun getPosts(): Resource<Flow<List<Post>>>
    suspend fun addPost(post: Post): Resource<Unit>
}