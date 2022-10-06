package com.kromer.data.features.posts.mappers

import com.kromer.data.features.posts.models.PostEntity
import com.kromer.domain.base.mappers.ModelMapper
import com.kromer.domain.features.posts.models.Post

class PostMapper : ModelMapper<PostEntity, Post> {
    override fun mapFrom(from: PostEntity): Post {
        return Post(
            id = from.id ?: 0,
            originalPhotoPath = from.originalPhotoPath,
            photoPath = from.photoPath,
        )
    }

    override fun mapTo(to: Post): PostEntity {
        return PostEntity(
            originalPhotoPath = to.originalPhotoPath,
            photoPath = to.photoPath,
        )
    }
}