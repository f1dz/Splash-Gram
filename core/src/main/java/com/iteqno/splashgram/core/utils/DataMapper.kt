package com.iteqno.splashgram.core.utils

import com.iteqno.splashgram.core.data.source.local.entity.*
import com.iteqno.splashgram.core.data.source.remote.response.PhotoResponse
import com.iteqno.splashgram.core.domain.model.*

object DataMapper {
    fun mapResponseToEntities(input: List<PhotoResponse>) : List<PhotoEntity> {
        val photoList = ArrayList<PhotoEntity>()
        input.map {
            val photo = PhotoEntity(
                id = it.id,
                color = it.color,
                createdAt = it.createdAt,
                description = it.description,
                likedByUser = it.likedByUser,
                urls = it.urls,
                downloads = it.downloads,
                width = it.width,
                location = it.location,
                user = it.user,
                views = it.views,
                height = it.height,
                likes = it.likes,
                isLoved = false
            )
            photoList.add(photo)
        }
        return photoList
    }

    fun mapEntitiesToDomain(input: List<PhotoEntity>) : List<Photo> =
        input.map {
            Photo(
                id = it.id,
                color = it.color,
                createdAt = it.createdAt,
                description = it.description,
                likedByUser = it.likedByUser,
                urls = mapUrlsEntityToDomain(it.urls),
                downloads = it.downloads,
                width = it.width,
                location = mapLocationEntityToDomain(it.location),
                user = mapUserEntityToDomain(it.user),
                views = it.views,
                height = it.height,
                likes = it.likes,
                isLoved = it.isLoved
            )
        }

    fun mapDomainToEntity(it: Photo) =
        PhotoEntity(
            id = it.id,
            color = it.color,
            createdAt = it.createdAt,
            description = it.description,
            likedByUser = it.likedByUser,
            urls = mapUrlsDomainToEntity(it.urls),
            downloads = it.downloads,
            width = it.width,
            location = mapLocationDomainToEntity(it.location),
            user = mapUserDomainToEntity(it.user),
            views = it.views,
            height = it.height,
            likes = it.likes
        )

    private fun mapUrlsDomainToEntity(input: Urls) =
        UrlsEntity(
            small = input.small,
            thumb = input.thumb,
            raw = input.raw,
            regular = input.regular,
            full = input.full
        )

    private fun mapUrlsEntityToDomain(input: UrlsEntity) =
        Urls(
            small = input.small,
            thumb = input.thumb,
            raw = input.raw,
            regular = input.regular,
            full = input.full
        )

    private fun mapLocationEntityToDomain(input: LocationEntity?) =
        Location(
            country = input?.country,
            city = input?.city,
            name = input?.name,
            title = input?.title
        )

    private fun mapLocationDomainToEntity(input: Location?) =
        LocationEntity(
            country = input?.country,
            city = input?.city,
            name = input?.name,
            title = input?.title
        )

    private fun mapUserEntityToDomain(input: UserEntity) =
        User(
            name = input.name,
            lastName = input.lastName,
            firstName = input.firstName,
            bio = input.bio,
            username = input.username,
            profileImage = mapProfileImageEntityToDomain(input.profileImage)
        )

    private fun mapUserDomainToEntity(input: User) =
        UserEntity(
            name = input.name,
            lastName = input.lastName,
            firstName = input.firstName,
            bio = input.bio,
            username = input.username,
            profileImage = mapProfileImageDomainToEntity(input.profileImage)
        )

    private fun mapProfileImageEntityToDomain(input: ProfileImageEntity) =
        ProfileImage(
            small = input.small,
            large = input.large,
            medium = input.medium
        )

    private fun mapProfileImageDomainToEntity(input: ProfileImage) =
        ProfileImageEntity(
            small = input.small,
            large = input.large,
            medium = input.medium
        )
}