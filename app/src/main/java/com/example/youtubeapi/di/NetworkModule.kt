package com.example.youtubeapi.di

import com.example.youtubeapi.date.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideVideoCategoryApiService() = retrofitClient.provideVideoCategory()

    @Singleton
    @Provides
    fun provideVideoPopularApiService() = retrofitClient.provideVideoPopular()
}