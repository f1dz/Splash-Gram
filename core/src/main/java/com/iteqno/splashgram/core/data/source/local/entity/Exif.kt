package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exif(

    @ColumnInfo(name = "exposure_time")
    @field:SerializedName("exposure_time")
    val exposureTime: String? = null,

    @ColumnInfo(name = "aperture")
    @field:SerializedName("aperture")
    val aperture: String? = null,

    @ColumnInfo(name = "focal_length")
    @field:SerializedName("focal_length")
    val focalLength: String? = null,

    @ColumnInfo(name = "iso")
    @field:SerializedName("iso")
    val iso: Int? = null,

    @ColumnInfo(name = "model")
    @field:SerializedName("model")
    val model: String? = null,

    @ColumnInfo(name = "make")
    @field:SerializedName("make")
    val make: String? = null
): Parcelable