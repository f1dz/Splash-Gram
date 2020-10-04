package com.iteqno.splashgram.core.domain.repository

import com.iteqno.splashgram.core.data.Resource
import com.iteqno.splashgram.core.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface ISplashGramRepository {

    fun getAllPhoto(): Flow<Resource<List<Photo>>>

    fun getLovedPhotos(): Flow<List<Photo>>

    fun setLovedPhoto(photo: Photo, state: Boolean)
}