package com.riluq.animeapp.network

data class ScheduleResponse(
    val monday: List<Schedule>,

    val tuesday: List<Schedule>,

    val wednesday: List<Schedule>,

    val thursday: List<Schedule>,

    val friday: List<Schedule>,

    val saturday: List<Schedule>,

    val sunday: List<Schedule>,

    val other: List<Schedule>,

    val unknown: List<Schedule>
)