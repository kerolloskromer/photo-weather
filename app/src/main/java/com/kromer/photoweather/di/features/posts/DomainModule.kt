package com.kromer.photoweather.di.features.posts

import com.kromer.domain.features.posts.repository.PostsRepository
import com.kromer.domain.features.posts.usecases.AddPostUseCase
import com.kromer.domain.features.posts.usecases.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetPostsUseCase(
        repository: PostsRepository
    ): GetPostsUseCase = GetPostsUseCase(repository)

    @Provides
    @Singleton
    fun provideAddPostUseCase(
        repository: PostsRepository
    ): AddPostUseCase = AddPostUseCase(repository)
}
