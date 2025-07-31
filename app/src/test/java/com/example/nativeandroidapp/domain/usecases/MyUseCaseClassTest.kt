package com.example.nativeandroidapp.domain.usecases

import com.example.nativeandroidapp.domain.repo.MyRepository
import com.example.nativeandroidapp.domain.model.Response
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class MyUseCaseClassTest{

    private lateinit var useCaseClass: MyUseCaseClass
    private lateinit var repository: MyRepository

    @Before
    fun setup(){
        repository = mockk()
        useCaseClass = MyUseCaseClass(repository)
    }


    @Test
    fun `api send correct dara`() = runBlocking {
        val mockPosts = arrayListOf(Response(1,1,"Heading","body data"))

        coEvery { repository.fetchUserData() } returns mockPosts

        val result = useCaseClass.fetchUserDataFromRemote()
        // Act
        assertEquals(mockPosts, result)
        coVerify { repository.fetchUserData() }
    }
}