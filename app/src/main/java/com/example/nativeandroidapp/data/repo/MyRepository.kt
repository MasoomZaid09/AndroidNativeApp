package com.example.nativeandroidapp.data.repo

import com.example.nativeandroidapp.domain.model.Response


interface MyRepository {
    suspend fun fetchUserData() : ArrayList<Response>
}