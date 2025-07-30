package com.example.nativeandroidapp.data.api

import com.example.nativeandroidapp.domain.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {

    @GET("/posts")
    suspend fun fetchUserData(): ArrayList<Response>
}