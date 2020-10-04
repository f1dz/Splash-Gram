package com.iteqno.splashgram.core.utils

import android.icu.text.Transliterator
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iteqno.splashgram.core.data.source.local.entity.LocationEntity
import com.iteqno.splashgram.core.data.source.local.entity.ProfileImageEntity
import com.iteqno.splashgram.core.data.source.local.entity.UrlsEntity
import com.iteqno.splashgram.core.data.source.local.entity.UserEntity

class Converter {

    @TypeConverter
    fun toLocation(locationString: String?): LocationEntity? {
        val type = object : TypeToken<LocationEntity>() {}.type
        return Gson().fromJson(locationString, type)
    }

    @TypeConverter
    fun fromLocation(location: LocationEntity?): String? {
        val type = object : TypeToken<LocationEntity>() {}.type
        return Gson().toJson(location, type)
    }

    @TypeConverter
    fun toPosition(positionString: String?): Transliterator.Position? {
        val type = object : TypeToken<Transliterator.Position>() {}.type
        return Gson().fromJson(positionString, type)
    }

    @TypeConverter
    fun fromPosition(position: Transliterator.Position?): String? {
        val type = object : TypeToken<Transliterator.Position>() {}.type
        return Gson().toJson(position, type)
    }

    @TypeConverter
    fun toProfileImage(profileImageString: String?): ProfileImageEntity? {
        val type = object : TypeToken<ProfileImageEntity>() {}.type
        return Gson().fromJson(profileImageString, type)
    }

    @TypeConverter
    fun fromProfileImage(profileImage: ProfileImageEntity?): String? {
        val type = object : TypeToken<ProfileImageEntity>() {}.type
        return Gson().toJson(profileImage, type)
    }

    @TypeConverter
    fun toUrls(urlsString: String?): UrlsEntity? {
        val type = object : TypeToken<UrlsEntity>() {}.type
        return Gson().fromJson(urlsString, type)
    }

    @TypeConverter
    fun fromUrls(urls: UrlsEntity?): String? {
        val type = object : TypeToken<UrlsEntity>() {}.type
        return Gson().toJson(urls, type)
    }

    @TypeConverter
    fun toUser(userString: String?): UserEntity? {
        val type = object : TypeToken<UserEntity>() {}.type
        return Gson().fromJson(userString, type)
    }

    @TypeConverter
    fun fromUser(user: UserEntity?): String? {
        val type = object : TypeToken<UserEntity>() {}.type
        return Gson().toJson(user, type)
    }
}