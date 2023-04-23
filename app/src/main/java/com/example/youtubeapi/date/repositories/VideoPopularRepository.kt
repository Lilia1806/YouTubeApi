package com.example.youtubeapi.date.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.youtubeapi.base.BaseRepository
import com.example.youtubeapi.date.remote.apiservice.VideoPopularApiService
import com.example.youtubeapi.date.repositories.pagingsource.VideoPopularPagingSource
import javax.inject.Inject

class VideoPopularRepository @Inject constructor(
    private val videoPopularApiService: VideoPopularApiService
) : BaseRepository() {

    fun fetchVideoPopular() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        VideoPopularPagingSource(videoPopularApiService)
    }.liveData
}
