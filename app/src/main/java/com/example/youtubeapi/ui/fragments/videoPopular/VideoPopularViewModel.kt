package com.example.youtubeapi.ui.fragments.videoPopular

import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.date.repositories.VideoPopularRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoPopularViewModel @Inject constructor(
    private val videoPopularRepository: VideoPopularRepository
) : BaseViewModel() {

    fun fetchVideoPopular() = videoPopularRepository.fetchVideoPopular()
}