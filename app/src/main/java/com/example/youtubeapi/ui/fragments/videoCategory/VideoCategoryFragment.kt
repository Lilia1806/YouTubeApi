package com.example.youtubeapi.ui.fragments.videoCategory

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.databinding.FragmentVideoBinding
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.ui.adapters.VideoCategoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VideoCategoryFragment :
    BaseFragment<FragmentVideoBinding, VideoCategoryViewModel>(R.layout.fragment_video) {

    override val binding by viewBinding(FragmentVideoBinding::bind)
    override val viewModel: VideoCategoryViewModel by viewModels()
    private var videoAdapter = VideoCategoryAdapter()

    override fun initialize() {
        Toast.makeText(requireContext(), "anime", Toast.LENGTH_SHORT).show()
        binding.rvVideos.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = videoAdapter
        }
    }
}