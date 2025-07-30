package com.example.nativeandroidapp.domain.repo

import com.example.nativeandroidapp.data.api.MyApi
import com.example.nativeandroidapp.data.repo.MyRepository
import com.example.nativeandroidapp.domain.model.Response
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(private val myApi: MyApi) : MyRepository {

    override suspend fun fetchUserData() : ArrayList<Response>{
        return myApi.fetchUserData()
    }
}