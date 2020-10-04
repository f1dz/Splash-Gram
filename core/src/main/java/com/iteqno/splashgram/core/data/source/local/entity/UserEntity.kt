package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserEntity(

    @field:SerializedName("last_name")
    val lastName: String = "",

    @field:SerializedName("bio")
    val bio: String = "",

    @field:SerializedName("profile_image")
    val profileImage: ProfileImageEntity,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("first_name")
    val firstName: String,

    @field:SerializedName("username")
    val username: String
) : Parcelable