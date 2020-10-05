package com.iteqno.splashgram.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.iteqno.splashgram.core.data.source.remote.RemoteDataSource
import com.iteqno.splashgram.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class SearchViewModel(private val remoteDataSource: RemoteDataSource) : ViewModel() {

    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)
    fun searchResult() = queryChannel.asFlow()
        .debounce(1000)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .mapLatest {
            if(it.length > 2) remoteDataSource.getAllPhoto(it)
            else flow {
                emit(ApiResponse.Empty)
            }
        }
        .asLiveData()

}