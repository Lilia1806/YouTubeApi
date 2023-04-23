package com.example.youtubeapi.models

import com.example.youtubeapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class VideoModel(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    override val url: String,
    @SerializedName("snippet")
    val snippet: Snippet
) : IBaseDiffModel

data class Statistics(
    @SerializedName("viewCount")
    val viewCount: String,
    @SerializedName("likeCount")
    val likeCount: String,
)

data class Thumbnails(
    @SerializedName("high")
    val high: High
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
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("assignable")
    val assignable: Boolean
)
