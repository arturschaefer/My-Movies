package com.schaefer.mymovies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleData(
    val time: String,
    val days: List<String>
)