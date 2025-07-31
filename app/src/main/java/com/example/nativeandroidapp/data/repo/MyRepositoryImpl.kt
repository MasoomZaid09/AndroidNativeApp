package com.example.nativeandroidapp.data.repo

import com.example.nativeandroidapp.data.api.MyApi
import com.example.nativeandroidapp.data.local.dao.PostDao
import com.example.nativeandroidapp.data.local.entities.PostEntity
import com.example.nativeandroidapp.domain.model.Response
import com.example.nativeandroidapp.domain.repo.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(private val myApi: MyApi, private val postDao: PostDao) :
    MyRepository {

    override suspend fun fetchUserData() : ArrayList<Response>{
        val posts = myApi.fetchUserData()

        if (posts.isNotEmpty()){
            posts.forEach {
                postDao.insertPosts(PostEntity(it.id, it.userId, it.title, it.body))
            }
        }

        return myApi.fetchUserData()
    }

    override suspend fun fetchUserDataFromLocalDB(): ArrayList<Response> {
        val posts = postDao.getAllPosts()

        return if (posts.isNotEmpty()){
            ArrayList(posts.map { postEntity ->
                Response(postEntity.id, postEntity.userId, postEntity.title, postEntity.body)
            })
        }else{
            ArrayList()
        }
    }


}