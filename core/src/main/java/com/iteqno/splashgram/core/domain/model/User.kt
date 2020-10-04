package com.iteqno.splashgram.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val lastName: String,
    val bio: String,
    val profileImage: ProfileImage,
    val name: String,
    val firstName: String,
    val username: String
) : Parcelable