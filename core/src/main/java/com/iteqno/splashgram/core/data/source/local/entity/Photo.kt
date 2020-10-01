package com.iteqno.splashgram.core.data.source.local.entity

import android.location.Location
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "photo")
data class Photo(
	@PrimaryKey
	@NonNull
	@field:SerializedName("id")
	@ColumnInfo(name = "id")
	val id: String? = null,

	@Embedded
	@ColumnInfo(name = "current_user_collections")
	@field:SerializedName("current_user_collections")
	val currentUserCollections: List<String>? = null,

	@ColumnInfo(name = "color")
	@field:SerializedName("color")
	val color: String? = null,

	@ColumnInfo(name = "sponsorship")
	@field:SerializedName("sponsorship")
	val sponsorship: String = "",

	@ColumnInfo(name = "sponsorship")
	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@ColumnInfo(name = "description")
	@field:SerializedName("description")
	val description: String? = null,

	@ColumnInfo(name = "liked_by_user")
	@field:SerializedName("liked_by_user")
	val likedByUser: Boolean = false,

	@Embedded
	@ColumnInfo(name = "urls")
	@field:SerializedName("urls")
	val urls: Urls? = null,

	@ColumnInfo(name = "alt_description")
	@field:SerializedName("alt_description")
	val altDescription: String? = null,

	@ColumnInfo(name = "updated_at")
	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@ColumnInfo(name = "downloads")
	@field:SerializedName("downloads")
	val downloads: Int = 0,

	@ColumnInfo(name = "width")
	@field:SerializedName("width")
	val width: Int = 0,

	@ColumnInfo(name = "blur_hash")
	@field:SerializedName("blur_hash")
	val blurHash: String? = null,

	@Embedded
	@ColumnInfo(name = "links")
	@field:SerializedName("links")
	val links: Links? = null,

	@Embedded
	@ColumnInfo(name = "location")
	@field:SerializedName("location")
	val location: Location? = null,

	@Embedded
	@ColumnInfo(name = "categories")
	@field:SerializedName("categories")
	val categories: List<String>? = null,

	@ColumnInfo(name = "promoted_at")
	@field:SerializedName("promoted_at")
	val promotedAt: String? = null,

	@Embedded
	@ColumnInfo(name = "user")
	@field:SerializedName("user")
	val user: User? = null,

	@ColumnInfo(name = "views")
	@field:SerializedName("views")
	val views: Int = 0,

	@ColumnInfo(name = "height")
	@field:SerializedName("height")
	val height: Int = 0,

	@ColumnInfo(name = "likes")
	@field:SerializedName("likes")
	val likes: Int = 0,

	@Embedded
	@ColumnInfo(name = "exif")
	@field:SerializedName("exif")
	val exif: Exif? = null,

	@ColumnInfo(name = "isLoved")
	var isLoved: Boolean = false
): Parcelable
