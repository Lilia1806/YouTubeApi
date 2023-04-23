package com.example.youtubeapi.date.remote

import com.example.youtubeapi.date.remote.apiservice.VideoCategoryApiService
import com.example.youtubeapi.date.remote.apiservice.VideoPopularApiService
import com.example.youtubeapi.date.remote.interceptors.ApiKeyInterceptor
import com.example.youtubeapi.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(ApiKeyInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideVideoCategory() = retrofitClient.create(VideoCategoryApiService::class.java)

    fun provideVideoPopular() = retrofitClient.create(VideoPopularApiService::class.java)
}