package com.example.nativeandroidapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nativeandroidapp.data.local.dao.PostDao
import com.example.nativeandroidapp.data.local.entities.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class MyDataBase : RoomDatabase() {
    abstract fun postDao(): PostDao
}