package com.kromer.data.features.posts.repository

import com.kromer.data.base.BaseRepositoryImpl
import com.kromer.data.features.posts.datasource.local.PostsLocalDataSource
import com.kromer.data.features.posts.mappers.PostMapper
import com.kromer.domain.base.mappers.mapFromWith
import com.kromer.domain.base.mappers.mapToWith
import com.kromer.domain.features.posts.models.Post
import com.kromer.domain.features.posts.repository.PostsRepository
import com.kromer.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostsRepositoryImpl(
    private val postsLocalDataSource: PostsLocalDataSource,
    private val postMapper: PostMapper,
) : PostsRepository, BaseRepositoryImpl() {
    override suspend fun getPosts(): Resource<Flow<List<Post>>> =
        safeCall { postsLocalDataSource.getPosts().map { value -> value.mapFromWith(postMapper) } }

    override suspend fun addPost(post: Post): Resource<Unit> =
        safeCall { postsLocalDataSource.addPost(post.mapToWith(postMapper)) }

    override suspend fun getById(id: Long?): Resource<Post?> =
        safeCall { postsLocalDataSource.getById(id)?.mapFromWith(postMapper) }
}