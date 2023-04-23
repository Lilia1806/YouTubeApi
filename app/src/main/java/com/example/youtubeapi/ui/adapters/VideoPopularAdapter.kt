package com.example.youtubeapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_4_lesson_1.databinding.ItemVideoBinding
import com.example.youtubeapi.base.BaseDiffUtilItemCallback
import com.example.youtubeapi.extension.setImage
import com.example.youtubeapi.models.VideoModel

class VideoPopularAdapter : PagingDataAdapter<VideoModel, VideoPopularAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class ViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(videoModel: VideoModel) {
            binding.imageVideo.setImage(videoModel.snippet.thumbnails.maxRes.url)
            binding.channelName.text = videoModel.statistics.viewCount
            binding.videoData.text = videoModel.snippet.publishedAt
            binding.nameVideo.text = videoModel.snippet.title
            binding.peopleWatch.text = videoModel.statistics.viewCount
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