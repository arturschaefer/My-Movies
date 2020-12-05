package com.schaefer.mymovies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageData (
	val medium : String,
	val original : String
)