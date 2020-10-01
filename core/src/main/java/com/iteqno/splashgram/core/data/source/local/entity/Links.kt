package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links(

    @ColumnInfo(name = "followers")
    @field:SerializedName("followers")
    val followers: String? = null,

    @ColumnInfo(name = "portfolio")
    @field:SerializedName("portfolio")
    val portfolio: String? = null,

    @ColumnInfo(name = "following")
    @field:SerializedName("following")
    val following: String? = null,

    @ColumnInfo(name = "self")
    @field:SerializedName("self")
    val self: String? = null,

    @ColumnInfo(name = "html")
    @field:SerializedName("html")
    val html: String? = null,

    @ColumnInfo(name = "photos")
    @field:SerializedName("photos")
    val photos: String? = null,

    @ColumnInfo(name = "likes")
    @field:SerializedName("likes")
    val likes: String? = null,

    @ColumnInfo(name = "download")
    @field:SerializedName("download")
    val download: String? = null,

    @ColumnInfo(name = "download_location")
    @field:SerializedName("download_location")
    val downloadLocation: String? = null
): Parcelable