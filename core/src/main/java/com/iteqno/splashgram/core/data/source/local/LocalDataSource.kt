package com.iteqno.splashgram.core.data.source.local

import com.iteqno.splashgram.core.data.source.local.entity.Photo
import com.iteqno.splashgram.core.data.source.local.room.PhotoDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val photoDao: PhotoDao) {

    fun getAllPhoto(): Flow<List<Photo>> = photoDao.getAllPhoto()

    fun getLovedPhotos(): Flow<List<Photo>> = photoDao.getLovedPhotos()

    suspend fun insertPhoto(photoList: List<Photo>) = photoDao.insertPhoto(photoList)

    fun setLovedPhoto(photo: Photo, newState: Boolean) {
        photo.isLoved = newState
        photoDao.updateLovedPhoto(photo)
    }

}