package com.riluq.animeapp.network

import com.squareup.moshi.Json

data class TopAiring(
    @Json(name = "mal_id")
    val idTopAiring: Int? = null,

    @Json(name = "rank")
    val rankTopAiring: Int? = null,

    @Json(name = "title")
    val titleTopAiring: String? = null,

    @Json(name = "url")
    val urlTopAiring: String? = null,

    @Json(name = "image_url")
    val imageUrlTopAiring: String? = null,

    @Json(name = "type")
    val typeTopAiring: String? = null,

    @Json(name = "episodes")
    val episodesTopAiring: Int? = null,

    @Json(name = "start_date")
    val startDateTopAiring: String? = null,

    @Json(name = "end_date")
    val endDateTopAiring: String? = null,

    @Json(name = "members")
    val membersTopAiring: Int? = null,

    @Json(name = "score")
    val scoreTopAiring: Double? = null



)