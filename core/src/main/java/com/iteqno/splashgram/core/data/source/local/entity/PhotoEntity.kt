package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.iteqno.splashgram.core.utils.Converter
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "photo")
@TypeConverters(Converter::class)
data class PhotoEntity(
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "id")
	val id: String,

	@ColumnInfo(name = "color")
	val color: String,

	@ColumnInfo(name = "created_at")
	val createdAt: String,

	@ColumnInfo(name = "description")
	val description: String,

	@ColumnInfo(name = "liked_by_user")
	val likedByUser: Boolean = false,

	@ColumnInfo(name = "urls")
	val urls: UrlsEntity,

	@ColumnInfo(name = "updated_at")
	val updatedAt: String,

	@ColumnInfo(name = "downloads")
	val downloads: Int = 0,

	@ColumnInfo(name = "width")
	val width: Int = 0,

	@ColumnInfo(name = "location")
	val location: LocationEntity,

	@ColumnInfo(name = "user")
	val user: UserEntity,

	@ColumnInfo(name = "views")
	val views: Int = 0,

	@ColumnInfo(name = "height")
	val height: Int = 0,

	@ColumnInfo(name = "likes")
	val likes: Int = 0,

	@ColumnInfo(name = "isLoved")
	var isLoved: Boolean = false
): Parcelable
