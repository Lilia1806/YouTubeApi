package com.example.youtubeapi.date.remote.apiservice

import com.example.youtubeapi.models.VideoModel
import com.example.youtubeapi.models.YouTubeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoPopularApiService {

    @GET("videos")
    suspend fun fetchVideoPopular(
        @Query("regionCode") regionCode: String = "ru",
        @Query("part") part: String = "snippet,statistics",
        @Query("chart") chart: String = "mostPopular",
        @Query("pageToken") pageToken: String
    ): YouTubeResponse<VideoModel>
}