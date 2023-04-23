package com.example.youtubeapi.ui.fragments.videoPopular

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.databinding.FragmentVideoBinding
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.ui.adapters.VideoPopularAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VideoPopularFragment :
    BaseFragment<FragmentVideoBinding, VideoPopularViewModel>(R.layout.fragment_video) {

    override val binding by viewBinding(FragmentVideoBinding::bind)
    override val viewModel: VideoPopularViewModel by viewModels()
    private var videoAdapter = VideoPopularAdapter()

    override fun initialize() {
        binding.rvVideos.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = videoAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.fetchVideoPopular().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                videoAdapter.submitData(it)
            }
        }
    }
}