package com.riluq.animeapp.network

import com.squareup.moshi.Json

data class SeasonLater (
    @Json(name = "mal_id")
    val idSeasonLater: Int? = null,

    @Json(name = "url")
    val urlSeasonLater: String? = null,

    @Json(name = "title")
    val titleSeasonLater: String? = null,

    @Json(name = "image_url")
    val imageSeasonLater: String? = null,

    @Json(name = "synopsis")
    val synopsisSeasonLater: String? = null,

    @Json(name = "genres")
    val genresSeasonLater: List<Genre>? = null

)