package com.iteqno.splashgram.core.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iteqno.splashgram.core.data.source.local.entity.ProfileImageEntity

class Converter {

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

}