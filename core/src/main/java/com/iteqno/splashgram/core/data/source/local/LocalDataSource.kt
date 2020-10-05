package com.iteqno.splashgram.core.data.source.local

import com.iteqno.splashgram.core.data.source.local.entity.PhotoEntity
import com.iteqno.splashgram.core.data.source.local.room.PhotoDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LocalDataSource(private val photoDao: PhotoDao) {

    fun getAllPhoto(): Flow<List<PhotoEntity>> = photoDao.getAllPhoto()

    fun getLovedPhotos(): Flow<List<PhotoEntity>> = photoDao.getLovedPhotos()

    suspend fun insertPhotos(photoList: List<PhotoEntity>) = photoDao.insertPhotos(photoList)

    fun setLovedPhoto(photo: PhotoEntity, newState: Boolean) {
        photo.isLoved = newState
        GlobalScope.launch {
            if (photoDao.getPhoto(photo.id) == 0) {
                photoDao.insertPhoto(photo)
            } else {
                photoDao.updateLovedPhoto(photo)
            }
        }
    }

}