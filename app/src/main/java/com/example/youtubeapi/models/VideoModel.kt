package com.example.youtubeapi.models

import com.example.youtubeapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class VideoModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("snippet")
    val snippet: Snippet,
    @SerializedName("statistics")
    val statistics: Statistics,
    override val url: String
) : IBaseDiffModel

data class Statistics(
    @SerializedName("viewCount")
    val viewCount: String? = null,
    @SerializedName("likeCount")
    val likeCount: String
)

data class Thumbnails(
    @SerializedName("maxres")
    val maxRes: MaxRes
)

data class High(
    @SerializedName("url")
    val url: String
)

data class MaxRes(
    @SerializedName("url")
    val url: String
)

data class PageInfo(
    @SerializedName("totalResults")
    val totalResults: String = "",
    @SerializedName("resultsPerPage")
    val resultsPerPage: String = ""
)

data class Snippet(
    @SerializedName("channelId")
    val channelId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("assignable")
    val assignable: Boolean,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("channelTitle")
    val channelTitle: String,
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails
)