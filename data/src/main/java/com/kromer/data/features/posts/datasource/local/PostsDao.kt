package com.kromer.data.features.posts.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kromer.data.features.posts.models.PostEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PostsDao {

    @Query("SELECT * FROM posts ORDER BY id DESC")
    fun getAll(): Flow<List<PostEntity>>

    @Query("SELECT * FROM posts WHERE id = :id")
    suspend fun getById(id: Long?): PostEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: PostEntity)
}