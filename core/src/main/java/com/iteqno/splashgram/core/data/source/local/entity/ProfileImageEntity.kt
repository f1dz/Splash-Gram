package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileImageEntity(

    @field:SerializedName("small")
    val small: String = "",

    @field:SerializedName("large")
    val large: String = "",

    @field:SerializedName("medium")
    val medium: String = ""
) : Parcelable