package com.iteqno.splashgram.core.domain.usecase

import com.iteqno.splashgram.core.data.Resource
import com.iteqno.splashgram.core.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface SplashGramUseCase {
    fun getAllPhoto(query: String = ""): Flow<Resource<List<Photo>>>
    fun getLovedPhotos(): Flow<List<Photo>>
    fun setLovedPhoto(photo: Photo, state: Boolean)
}