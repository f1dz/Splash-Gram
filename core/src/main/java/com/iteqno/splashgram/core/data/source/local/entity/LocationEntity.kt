package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationEntity(

    @field:SerializedName("country")
    val country: String = "",

    @field:SerializedName("city")
    val city: String = "",

    @field:SerializedName("name")
    val name: String = "",

    @field:SerializedName("title")
    val title: String = ""
) : Parcelable