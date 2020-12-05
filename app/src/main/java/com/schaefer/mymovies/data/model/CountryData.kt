package com.schaefer.mymovies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryData(
    val name: String,
    val code: String,
    val timezone: String
)