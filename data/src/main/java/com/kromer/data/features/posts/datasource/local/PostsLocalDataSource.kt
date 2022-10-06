package com.kromer.data.features.posts.datasource.local

import com.kromer.data.features.posts.models.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostsLocalDataSource {
    suspend fun getPosts(): Flow<List<PostEntity>>
    suspend fun addPost(post: PostEntity)
}