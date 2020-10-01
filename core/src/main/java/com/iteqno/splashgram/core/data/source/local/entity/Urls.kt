package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Urls(

    @ColumnInfo(name = "small")
    @field:SerializedName("small")
    val small: String? = null,

    @ColumnInfo(name = "thumb")
    @field:SerializedName("thumb")
    val thumb: String? = null,

    @ColumnInfo(name = "raw")
    @field:SerializedName("raw")
    val raw: String? = null,

    @ColumnInfo(name = "regular")
    @field:SerializedName("regular")
    val regular: String? = null,

    @ColumnInfo(name = "full")
    @field:SerializedName("full")
    val full: String? = null
) : Parcelable