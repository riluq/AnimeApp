package com.riluq.animeapp.network

import com.squareup.moshi.Json

data class TopUpcoming (
    @Json(name = "mal_id")
    val idTopUpcoming: Int? = null,

    @Json(name = "rank")
    val rankTopUpcoming: Int? = null,

    @Json(name = "title")
    val titleTopUpcoming: String? = null,

    @Json(name = "url")
    val urlTopUpcoming: String? = null,

    @Json(name = "image_url")
    val imageUrlTopUpcoming: String? = null,

    @Json(name = "type")
    val typeTopUpcoming: String? = null,

    @Json(name = "episodes")
    val episodesTopUpcoming: Int? = null,

    @Json(name = "start_date")
    val startDateTopUpcoming: String? = null,

    @Json(name = "end_date")
    val endDateTopUpcoming: String? = null,

    @Json(name = "members")
    val membersTopUpcoming: Int? = null,

    @Json(name = "score")
    val scoreTopUpcoming: Double? = null
)