package com.iteqno.splashgram.core.data.source.remote

import android.util.Log
import com.iteqno.splashgram.core.data.source.remote.network.ApiResponse
import com.iteqno.splashgram.core.data.source.remote.network.ApiService
import com.iteqno.splashgram.core.data.source.remote.response.PhotoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    fun getAllPhoto(query: String = ""): Flow<ApiResponse<List<PhotoResponse>>> {
        return flow {
            try {
                val response = apiService.getPhotosRandom(query = query)
                if(response.isNotEmpty()){
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun searchPhoto(query: String): Flow<List<PhotoResponse>> {
        return flow {
            try {
                val response = apiService.getPhotosRandom(query = query)
                if(response.isNotEmpty()){
                    emit(response)
                }
            } catch (e: Exception) {

            }
        }
    }
}