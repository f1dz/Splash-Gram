package com.iteqno.splashgram.core.data

import com.iteqno.splashgram.core.data.source.local.LocalDataSource
import com.iteqno.splashgram.core.data.source.remote.RemoteDataSource
import com.iteqno.splashgram.core.data.source.remote.network.ApiResponse
import com.iteqno.splashgram.core.data.source.remote.response.PhotoResponse
import com.iteqno.splashgram.core.domain.model.Photo
import com.iteqno.splashgram.core.domain.repository.ISplashGramRepository
import com.iteqno.splashgram.core.utils.AppExecutors
import com.iteqno.splashgram.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhotoRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISplashGramRepository{

    override fun getAllPhoto(query: String): Flow<Resource<List<Photo>>> =
        object : NetworkBoundResource<List<Photo>, List<PhotoResponse>>(){
            override fun loadFromDB(): Flow<List<Photo>> {
                return localDataSource.getAllPhoto().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Photo>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<PhotoResponse>>> =
                remoteDataSource.getAllPhoto()

            override suspend fun saveCallRequest(data: List<PhotoResponse>) {
                val photoList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertPhotos(photoList)
            }
        }.asFlow()

    override fun getLovedPhotos(): Flow<List<Photo>> {
        return localDataSource.getLovedPhotos().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setLovedPhoto(photo: Photo, state: Boolean) {
        val photoEntity = DataMapper.mapDomainToEntity(photo)
        appExecutors.diskIO().execute { localDataSource.setLovedPhoto(photoEntity, state) }
    }
}