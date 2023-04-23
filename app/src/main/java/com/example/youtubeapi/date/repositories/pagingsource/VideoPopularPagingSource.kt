package com.example.youtubeapi.date.repositories.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.youtubeapi.date.remote.apiservice.VideoPopularApiService
import com.example.youtubeapi.models.VideoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val VIDEO_STARTING_PAGE_INDEX = ""

class VideoPopularPagingSource(private val videoPopularApiService: VideoPopularApiService) :
    PagingSource<String, VideoModel>() {

    override fun getRefreshKey(state: PagingState<String, VideoModel>): String? {
        var current: String? = ""

        val anchorPosition = state.anchorPosition

        CoroutineScope(Dispatchers.IO).launch {
            if (anchorPosition != null) {
                current = state.closestPageToPosition(anchorPosition)?.prevKey?.let {
                    videoPopularApiService.fetchVideoPopular(
                        pageToken = it
                    ).nextPageToken
                }
            }
        }
        return current
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, VideoModel> {
        return try {
            val startPage = params.key ?: VIDEO_STARTING_PAGE_INDEX
            val response = videoPopularApiService.fetchVideoPopular(
                pageToken = startPage as String
            )
            val nextPage = if (response.items.isEmpty()) null else response.nextPageToken
            val prevPage = if (startPage == VIDEO_STARTING_PAGE_INDEX) null else response.prevPageToken

            LoadResult.Page(
                data = response.items,
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}