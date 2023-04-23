package com.example.youtubeapi.date.remote.apiservice

import com.example.youtubeapi.models.VideoModel
import com.example.youtubeapi.models.YouTubeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoCategoryApiService {

    @GET("videoCategory")
    suspend fun fetchVideoCategory(
        @Query("part") pair: String = "snippet",
        @Query("regionCode") regionCode: String = "ru"
    ): YouTubeResponse<VideoModel>
}