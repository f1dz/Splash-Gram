package com.iteqno.splashgram.core.data.source.local.room

import androidx.room.*
import com.iteqno.splashgram.core.data.source.local.entity.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photo")
    fun getAllPhoto(): Flow<List<PhotoEntity>>

    @Query("SELECT * FROM photo WHERE isLoved = 1")
    fun getLovedPhotos(): Flow<List<PhotoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photo: List<PhotoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photo: PhotoEntity)

    @Query("SELECT COUNT(*) FROM photo WHERE id = :id")
    suspend fun getPhoto(id: String): Int

    @Update
    fun updateLovedPhoto(photo: PhotoEntity)

}