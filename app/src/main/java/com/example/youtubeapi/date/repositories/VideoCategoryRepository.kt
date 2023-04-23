package com.example.youtubeapi.date.repositories

import com.example.youtubeapi.base.BaseRepository
import com.example.youtubeapi.date.remote.apiservice.VideoCategoryApiService
import javax.inject.Inject

class VideoCategoryRepository @Inject constructor(
    private val videoCategoryApiService: VideoCategoryApiService
) : BaseRepository() {

    fun fetchVideoCategory() = doRequest {
        videoCategoryApiService.fetchVideoCategory()
    }
}