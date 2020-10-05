package com.iteqno.splashgram.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Urls(
    val small: String,
    val thumb: String,
    val raw: String,
    val regular: String,
    val full: String
) : Parcelable