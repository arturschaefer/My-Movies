package com.schaefer.mymovies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ShowData (
	val id : Int,
	val url : String,
	val name : String,
	val type : String,
	val language : String,
	val genres : List<String>,
	val status : String,
	val runtime : Int,
	val premiered : String,
	val officialSite : String,
	val scheduleData : ScheduleData,
	val ratingData : RatingData,
	val weight : Int,
	val networkData : NetworkData,
	val webChannelData : WebChannelData,
	val externalsData : ExternalsData,
	val imageData : ImageData,
	val summary : String,
	val updated : Int,
	val linksData : LinksData
)