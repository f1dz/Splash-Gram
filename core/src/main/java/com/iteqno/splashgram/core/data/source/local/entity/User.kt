package com.iteqno.splashgram.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

    @ColumnInfo(name = "total_photos")
    @field:SerializedName("total_photos")
    val totalPhotos: Int? = null,

    @ColumnInfo(name = "accepted_tos")
    @field:SerializedName("accepted_tos")
    val acceptedTos: Boolean? = null,

    @ColumnInfo(name = "twitter_username")
    @field:SerializedName("twitter_username")
    val twitterUsername: String? = null,

    @ColumnInfo(name = "last_name")
    @field:SerializedName("last_name")
    val lastName: String? = null,

    @ColumnInfo(name = "bio")
    @field:SerializedName("bio")
    val bio: String? = null,

    @ColumnInfo(name = "total_likes")
    @field:SerializedName("total_likes")
    val totalLikes: Int? = null,

    @ColumnInfo(name = "portfolio_url")
    @field:SerializedName("portfolio_url")
    val portfolioUrl: String? = null,

    @ColumnInfo(name = "profile_image")
    @field:SerializedName("profile_image")
    val profileImage: ProfileImage? = null,

    @ColumnInfo(name = "updated_at")
    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @ColumnInfo(name = "name")
    @field:SerializedName("name")
    val name: String? = null,

    @ColumnInfo(name = "location")
    @field:SerializedName("location")
    val location: String? = null,

    @ColumnInfo(name = "links")
    @field:SerializedName("links")
    val links: Links? = null,

    @ColumnInfo(name = "total_collections")
    @field:SerializedName("total_collections")
    val totalCollections: Int? = null,

    @ColumnInfo(name = "id")
    @field:SerializedName("id")
    val id: String? = null,

    @ColumnInfo(name = "first_name")
    @field:SerializedName("first_name")
    val firstName: String? = null,

    @ColumnInfo(name = "instagram_username")
    @field:SerializedName("instagram_username")
    val instagramUsername: String? = null,

    @ColumnInfo(name = "username")
    @field:SerializedName("username")
    val username: String? = null
) : Parcelable