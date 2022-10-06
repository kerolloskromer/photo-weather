package com.kromer.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kromer.data.features.posts.datasource.local.PostsDao
import com.kromer.data.features.posts.models.PostEntity

@Database(entities = [PostEntity::class], version = MyDatabase.DATABASE_VERSION)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "PhotoWeatherDatabase"
    }

    abstract fun getPostsDao(): PostsDao
}