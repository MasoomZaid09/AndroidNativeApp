package com.example.nativeandroidapp.ui.di

import com.example.nativeandroidapp.data.api.MyApi
import com.example.nativeandroidapp.data.repo.MyRepository
import com.example.nativeandroidapp.domain.repo.MyRepositoryImpl
import com.example.nativeandroidapp.domain.usecases.MyUseCaseClass
import com.example.nativeandroidapp.ui.constants.Contants.Base_Url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder()
        .baseUrl(Base_Url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit) : MyApi = retrofit.create(MyApi::class.java)

    @Provides
    fun provideRepo(myApi: MyApi): MyRepository = MyRepositoryImpl(myApi)

    @Provides
    fun provideUseCases(myRepository: MyRepository) : MyUseCaseClass = MyUseCaseClass(myRepository)



}