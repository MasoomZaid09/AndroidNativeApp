package com.example.nativeandroidapp.domain.repo

import com.example.nativeandroidapp.domain.model.Response


interface MyRepository {
    suspend fun fetchUserData() : ArrayList<Response>
    suspend fun fetchUserDataFromLocalDB() : ArrayList<Response>
}