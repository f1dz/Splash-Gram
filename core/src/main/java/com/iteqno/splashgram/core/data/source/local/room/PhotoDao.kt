package com.iteqno.splashgram.core.data.source.local.room

import androidx.room.*
import com.iteqno.splashgram.core.data.source.local.entity.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photo")
    fun getAllPhoto(): Flow<List<Photo>>

    @Query("SELECT * FROM photo WHERE isLoved = 1")
    fun getLovedPhotos(): Flow<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photo: List<Photo>)

    @Update
    fun updateLovedPhoto(photo: Photo)

}