package com.skilbox.nytimesmovies.plugins.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkRetrofit {
    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.nytimes.com/svc/movies/v2/reviews/")
        .client(okHttpClient)
        .build()

    val movieReviewsAPI: MovieReviewsAPI
        get() = retrofit.create()
}
