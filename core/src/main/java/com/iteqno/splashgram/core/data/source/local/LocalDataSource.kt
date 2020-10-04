package com.iteqno.splashgram.core.data.source.local

import com.iteqno.splashgram.core.data.source.local.entity.PhotoEntity
import com.iteqno.splashgram.core.data.source.local.room.PhotoDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val photoDao: PhotoDao) {

    fun getAllPhoto(): Flow<List<PhotoEntity>> = photoDao.getAllPhoto()

    fun getLovedPhotos(): Flow<List<PhotoEntity>> = photoDao.getLovedPhotos()

    suspend fun insertPhoto(photoList: List<PhotoEntity>) = photoDao.insertPhoto(photoList)

    fun setLovedPhoto(photo: PhotoEntity, newState: Boolean) {
        photo.isLoved = newState
        photoDao.updateLovedPhoto(photo)
    }

}