package com.schaefer.mymovies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LinksData (
	val selfData : SelfData,
	val previousEpisodeData : PreviousEpisodeData
)