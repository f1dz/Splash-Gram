package com.iteqno.splashgram.core.data.source.remote.network

import com.iteqno.splashgram.core.data.source.remote.response.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("photos/random")
    suspend fun getPhotosRandom(
        @Query("count") count: Int = 30,
        @Query("orientation") orientation: String = "landscape",
        @Query("query") query: String = ""
    ) : List<PhotoResponse>
}