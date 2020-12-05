package com.schaefer.mymovies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ExternalsData (
	val tvrage : Int,
	val thetvdb : Int,
	val imdb : String
)