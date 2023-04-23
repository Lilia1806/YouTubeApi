package com.example.youtubeapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_4_lesson_1.databinding.ItemVideoBinding
import com.example.youtubeapi.base.BaseDiffUtilItemCallback
import com.example.youtubeapi.models.VideoModel

class VideoPopularAdapter : PagingDataAdapter<VideoModel, VideoPopularAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class ViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(videoModel: VideoModel) {
            binding.nameVideo.text = videoModel.snippet.title
            binding.channelName.text = videoModel.snippet.channelId
            binding.videoData.text = videoModel.snippet.publishedAt
            Glide.with(binding.imageVideo).load(videoModel.snippet.assignable)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}