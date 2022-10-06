package com.kromer.data.features.posts.datasource.local

import com.kromer.data.features.posts.models.PostEntity
import kotlinx.coroutines.flow.Flow

class PostsLocalDataSourceImpl(
    private val postsDao: PostsDao,
) : PostsLocalDataSource {
    override suspend fun getPosts(): Flow<List<PostEntity>> = postsDao.getAll()

    override suspend fun addPost(post: PostEntity) = postsDao.insert(post)
}