package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(

    @ColumnInfo(name = "country")
    @field:SerializedName("country")
    val country: String? = null,

    @ColumnInfo(name = "city")
    @field:SerializedName("city")
    val city: String? = null,

    @ColumnInfo(name = "name")
    @field:SerializedName("name")
    val name: String? = null,

    @ColumnInfo(name = "position")
    @field:SerializedName("position")
    val position: Position? = null,

    @ColumnInfo(name = "title")
    @field:SerializedName("title")
    val title: String? = null
) : Parcelable