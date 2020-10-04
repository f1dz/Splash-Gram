package com.iteqno.splashgram.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val country: String,
    val city: String,
    val name: String,
    val title: String
) : Parcelable