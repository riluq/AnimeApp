package com.riluq.animeapp.network

import com.squareup.moshi.Json

data class Genre (

    @Json(name = "mal_id")
    val idGenre: Int? = null,

    @Json(name = "type")
    val typeGenre: String? = null,

    @Json(name = "name")
    val nameGenre: String? = null,

    @Json(name = "url")
    val urlGenre: String? = null

)