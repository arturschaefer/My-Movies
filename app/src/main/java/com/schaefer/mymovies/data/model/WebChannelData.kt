package com.schaefer.mymovies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WebChannelData (
	val id : Int,
	val name : String,
	val countryData : CountryData
)