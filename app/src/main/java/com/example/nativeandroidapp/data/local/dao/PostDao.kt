package com.example.nativeandroidapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nativeandroidapp.data.local.entities.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    suspend fun getAllPosts(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: PostEntity)
}
