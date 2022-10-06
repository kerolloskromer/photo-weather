package com.kromer.photoweather.di.features.posts

import com.kromer.data.features.posts.datasource.local.PostsDao
import com.kromer.data.features.posts.datasource.local.PostsLocalDataSource
import com.kromer.data.features.posts.datasource.local.PostsLocalDataSourceImpl
import com.kromer.data.features.posts.mappers.PostMapper
import com.kromer.data.features.posts.repository.PostsRepositoryImpl
import com.kromer.data.sources.local.MyDatabase
import com.kromer.domain.features.posts.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providePostsDao(myDatabase: MyDatabase) = myDatabase.getPostsDao()

    @Provides
    @Singleton
    fun providePostsLocalDataSource(
        postsDao: PostsDao,
    ): PostsLocalDataSource =
        PostsLocalDataSourceImpl(postsDao)

    @Provides
    @Singleton
    fun providePostsRepository(
        postsLocalDataSource: PostsLocalDataSource,
        postMapper: PostMapper,
    ): PostsRepository =
        PostsRepositoryImpl(postsLocalDataSource, postMapper)

    @Provides
    @Singleton
    fun providePostMapper(): PostMapper = PostMapper()
}
