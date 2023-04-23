package com.example.youtubeapi.base

import androidx.lifecycle.liveData
import com.example.youtubeapi.utils.Resource
import java.io.IOException

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> T) = liveData {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(result()))
        } catch (exception: IOException) {
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}