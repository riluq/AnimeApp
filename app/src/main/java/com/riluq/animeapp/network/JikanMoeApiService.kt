package com.riluq.animeapp.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.jikan.moe/v3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface JikanMoeApiService {
    @GET("top/anime/1/airing")
    fun getTopAiringAsync():
            Deferred<TopAiringResponse>

    @GET("top/anime/1/upcoming")
    fun getTopUpcomingAsync():
            Deferred<TopUpcomingResponse>

    @GET("top/anime/1/favorite")
    fun getTopFavoriteAsync():
            Deferred<TopFavoriteResponse>
}

object JikanMoeApi {
    val retrofitService: JikanMoeApiService by lazy {
        retrofit.create(JikanMoeApiService::class.java)
    }
}