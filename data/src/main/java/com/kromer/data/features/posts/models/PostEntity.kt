package com.kromer.data.features.posts.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val originalPhotoPath: String,
    val photoPath: String,
)
