package com.iteqno.splashgram.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.iteqno.splashgram.core.data.source.remote.RemoteDataSource
import com.iteqno.splashgram.core.domain.model.Photo
import com.iteqno.splashgram.core.domain.usecase.SplashGramUseCase

class DetailViewModel(
    private val useCase: SplashGramUseCase,
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {

    fun setLovedPhoto(photo: Photo, newState: Boolean) = useCase.setLovedPhoto(photo, newState)

    fun getUserPhotos(user: String) = remoteDataSource.getUserPhotos(user).asLiveData()
}