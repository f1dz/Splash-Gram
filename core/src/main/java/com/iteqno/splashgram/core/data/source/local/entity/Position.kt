package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Position(

    @ColumnInfo(name = "latitude")
    @field:SerializedName("latitude")
    val latitude: Double? = null,

    @ColumnInfo(name = "longitude")
    @field:SerializedName("longitude")
    val longitude: Double? = null
) : Parcelable