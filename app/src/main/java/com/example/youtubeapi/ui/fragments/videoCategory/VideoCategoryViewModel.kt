package com.example.youtubeapi.ui.fragments.videoCategory

import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.date.repositories.VideoCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoCategoryViewModel @Inject constructor(
    private val videoCategoryRepository: VideoCategoryRepository
) : BaseViewModel() {

    fun fetchVideoCategory() = videoCategoryRepository.fetchVideoCategory()
}