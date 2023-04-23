package com.example.youtubeapi.ui.fragments.videoPopular

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.databinding.FragmentVideoPopularBinding
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.ui.adapters.VideoPopularAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VideoPopularFragment :
    BaseFragment<FragmentVideoPopularBinding, VideoPopularViewModel>(R.layout.fragment_video_popular) {

    override val binding by viewBinding(FragmentVideoPopularBinding::bind)
    override val viewModel: VideoPopularViewModel by viewModels()
    private var videoAdapter = VideoPopularAdapter()

    override fun initialize() {
        binding.rvVideos.adapter = videoAdapter
    }

    override fun setupSubscribes() {
        viewModel.fetchVideoPopular().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                videoAdapter.submitData(it)
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}