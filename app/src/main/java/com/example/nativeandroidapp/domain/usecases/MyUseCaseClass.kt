package com.example.nativeandroidapp.domain.usecases

import com.example.nativeandroidapp.data.repo.MyRepository
import com.example.nativeandroidapp.domain.model.Response
import javax.inject.Inject

class MyUseCaseClass @Inject constructor(private val myRepository: MyRepository) {

    suspend fun fetchUserDataFromRemote() : ArrayList<Response> = myRepository.fetchUserData()

}