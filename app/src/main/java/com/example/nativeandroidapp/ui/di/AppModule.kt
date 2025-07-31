package com.example.nativeandroidapp.ui.di

import android.content.Context
import androidx.room.Room
import com.example.nativeandroidapp.data.api.MyApi
import com.example.nativeandroidapp.data.local.dao.PostDao
import com.example.nativeandroidapp.data.local.db.MyDataBase
import com.example.nativeandroidapp.domain.repo.MyRepository
import com.example.nativeandroidapp.data.repo.MyRepositoryImpl
import com.example.nativeandroidapp.domain.usecases.MyUseCaseClass
import com.example.nativeandroidapp.ui.constants.Contants.Base_Url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder()
        .baseUrl(Base_Url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : MyApi = retrofit.create(MyApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MyDataBase {
        return Room.databaseBuilder(
            context,
            MyDataBase::class.java,
            "my_app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providePostDao(db: MyDataBase): PostDao {
        return db.postDao()
    }

    @Provides
    @Singleton
    fun provideRepo(myApi: MyApi,myDao: PostDao): MyRepository = MyRepositoryImpl(myApi,myDao)

    @Provides
    @Singleton
    fun provideUseCases(myRepository: MyRepository) : MyUseCaseClass = MyUseCaseClass(myRepository)



}