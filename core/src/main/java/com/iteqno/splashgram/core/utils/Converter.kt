package com.iteqno.splashgram.core.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iteqno.splashgram.core.data.source.local.entity.*

class Converter {
    @TypeConverter
    fun toExif(exifString: String?): Exif? {
        val type = object : TypeToken<Exif>() {}.type
        return Gson().fromJson<Exif>(exifString, type)
    }

    @TypeConverter
    fun fromExif(exif: Exif?): String? {
        val type = object : TypeToken<Exif>() {}.type
        return Gson().toJson(exif, type)
    }

    @TypeConverter
    fun toLinks(linksString: String?): Links? {
        val type = object : TypeToken<Links>() {}.type
        return Gson().fromJson(linksString, type)
    }

    @TypeConverter
    fun fromLinks(links: Links?): String? {
        val type = object : TypeToken<Links>() {}.type
        return Gson().toJson(links, type)
    }

    @TypeConverter
    fun toLocation(locationString: String?): Location? {
        val type = object : TypeToken<Location>() {}.type
        return Gson().fromJson(locationString, type)
    }

    @TypeConverter
    fun fromLocation(location: Location?): String? {
        val type = object : TypeToken<Location>() {}.type
        return Gson().toJson(location, type)
    }

    @TypeConverter
    fun toPosition(positionString: String?): Position? {
        val type = object : TypeToken<Position>() {}.type
        return Gson().fromJson(positionString, type)
    }

    @TypeConverter
    fun fromPosition(position: Position?): String? {
        val type = object : TypeToken<Position>() {}.type
        return Gson().toJson(position, type)
    }

    @TypeConverter
    fun toProfileImage(profileImageString: String?): ProfileImage? {
        val type = object : TypeToken<ProfileImage>() {}.type
        return Gson().fromJson(profileImageString, type)
    }

    @TypeConverter
    fun fromProfileImage(profileImage: ProfileImage?): String? {
        val type = object : TypeToken<ProfileImage>() {}.type
        return Gson().toJson(profileImage, type)
    }

    @TypeConverter
    fun toUrls(urlsString: String?): Urls? {
        val type = object : TypeToken<Urls>() {}.type
        return Gson().fromJson(urlsString, type)
    }

    @TypeConverter
    fun fromUrls(urls: Urls?): String? {
        val type = object : TypeToken<Urls>() {}.type
        return Gson().toJson(urls, type)
    }

    @TypeConverter
    fun toUser(userString: String?): User? {
        val type = object : TypeToken<User>() {}.type
        return Gson().fromJson(userString, type)
    }

    @TypeConverter
    fun fromUser(user: User?): String? {
        val type = object : TypeToken<User>() {}.type
        return Gson().toJson(user, type)
    }
}