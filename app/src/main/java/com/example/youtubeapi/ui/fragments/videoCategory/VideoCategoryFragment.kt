package com.example.youtubeapi.ui.fragments.videoCategory

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.databinding.FragmentVideoCategoryBinding
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.ui.adapters.VideoCategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoCategoryFragment :
    BaseFragment<FragmentVideoCategoryBinding, VideoCategoryViewModel>(R.layout.fragment_video_category) {

    override val binding by viewBinding(FragmentVideoCategoryBinding::bind)
    override val viewModel: VideoCategoryViewModel by viewModels()
    private var videoAdapter = VideoCategoryAdapter()

    override fun initialize() {
        binding.rvVideos.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = videoAdapter
        }
    }
}