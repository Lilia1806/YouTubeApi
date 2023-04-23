package com.example.youtubeapi.date.remote.apiservice

import com.example.youtubeapi.models.VideoModel
import com.example.youtubeapi.models.YouTubeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoPopularApiService {

    @GET("videoCategory")
    suspend fun fetchVideoPopular(
        @Query("part") pair: String = "snippet",
        @Query("regionCode") regionCode: String = "ru",
        @Query("chart") chart: String = "chart",
        @Query("pageToken") pageToken: String
    ): YouTubeResponse<VideoModel>
}