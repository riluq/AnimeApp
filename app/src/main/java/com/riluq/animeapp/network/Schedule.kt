package com.riluq.animeapp.network

import com.squareup.moshi.Json

data class Schedule (
    @Json(name = "mal_id")
    val idSchedule: Int? = null,

    @Json(name = "title")
    val titleSchedule: String? = null,

    @Json(name = "image_url")
    val imageSchedule: String? = null,

    @Json(name = "synopsis")
    val synopsisSchedule: String? = null,

    @Json(name = "airing_start")
    val airingStartSchedule: String? = null
)