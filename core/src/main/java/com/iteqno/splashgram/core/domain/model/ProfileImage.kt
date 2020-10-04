package com.iteqno.splashgram.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileImage(
    val small: String,
    val large: String,
    val medium: String
) : Parcelable