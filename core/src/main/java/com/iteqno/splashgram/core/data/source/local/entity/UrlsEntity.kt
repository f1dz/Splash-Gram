package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UrlsEntity(

    @field:SerializedName("small")
    val small: String,

    @field:SerializedName("thumb")
    val thumb: String,

    @field:SerializedName("raw")
    val raw: String,

    @field:SerializedName("regular")
    val regular: String,

    @field:SerializedName("full")
    val full: String
) : Parcelable