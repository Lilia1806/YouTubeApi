package com.example.youtubeapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_4_lesson_1.databinding.ItemVideoBinding
import com.example.youtubeapi.base.BaseDiffUtilItemCallback
import com.example.youtubeapi.models.VideoModel

class VideoCategoryAdapter : PagingDataAdapter<VideoModel, VideoCategoryAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class ViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(videoCategoryModel: VideoModel) {

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