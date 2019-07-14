package com.riluq.animeapp.network

import com.squareup.moshi.Json

data class TopFavorite (
    @Json(name = "mal_id")
    val idTopFavorite: Int? = null,

    @Json(name = "rank")
    val rankTopFavorite: Int? = null,

    @Json(name = "title")
    val titleTopFavorite: String? = null,

    @Json(name = "url")
    val urlTopFavorite: String? = null,

    @Json(name = "image_url")
    val imageUrlTopFavorite: String? = null,

    @Json(name = "type")
    val typeTopFavorite: String? = null,

    @Json(name = "episodes")
    val episodesTopFavorite: Int? = null,

    @Json(name = "start_date")
    val startDateTopFavorite: String? = null,

    @Json(name = "end_date")
    val endDateTopFavorite: String? = null,

    @Json(name = "members")
    val membersTopFavorite: Int? = null,

    @Json(name = "score")
    val scoreTopFavorite: Double? = null
)