package com.iteqno.splashgram.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.iteqno.splashgram.core.data.source.local.entity.LocationEntity
import com.iteqno.splashgram.core.data.source.local.entity.UrlsEntity
import com.iteqno.splashgram.core.data.source.local.entity.UserEntity

data class PhotoResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("color")
    val color: String = "",

    @field:SerializedName("created_at")
    val createdAt: String = "",

    @field:SerializedName("description")
    val description: String? = "",

    @field:SerializedName("liked_by_user")
    val likedByUser: Boolean = false,

    @field:SerializedName("urls")
    val urls: UrlsEntity,

    @field:SerializedName("updated_at")
    val updatedAt: String,

    @field:SerializedName("downloads")
    val downloads: Int = 0,

    @field:SerializedName("width")
    val width: Int = 0,

    @field:SerializedName("location")
    val location: LocationEntity?,

    @field:SerializedName("promoted_at")
    val promotedAt: String,

    @field:SerializedName("user")
    val user: UserEntity,

    @field:SerializedName("views")
    val views: Int = 0,

    @field:SerializedName("height")
    val height: Int = 0,

    @field:SerializedName("likes")
    val likes: Int = 0
)