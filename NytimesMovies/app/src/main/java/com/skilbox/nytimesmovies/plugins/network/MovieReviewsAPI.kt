package com.skilbox.nytimesmovies.plugins.network

import com.skilbox.nytimesmovies.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieReviewsAPI {

    @GET("all.json")
    suspend fun getDataFromAPI(@Query("offset") offset: Int, @Query("api-key") key: String): MovieList
}
