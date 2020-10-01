package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileImage(

    @ColumnInfo(name = "small")
    @field:SerializedName("small")
    val small: String? = null,

    @ColumnInfo(name = "large")
    @field:SerializedName("large")
    val large: String? = null,

    @ColumnInfo(name = "medium")
    @field:SerializedName("medium")
    val medium: String? = null
) : Parcelable