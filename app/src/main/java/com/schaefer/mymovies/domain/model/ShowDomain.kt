package com.schaefer.mymovies.domain.model

data class ShowDomain (
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
	val scheduleDomain : ScheduleDomain,
	val ratingDomain : RatingDomain,
	val weight : Int,
	val networkDomain : NetworkDomain,
	val webChannelDomain : WebChannelDomain,
	val externalsDomain : ExternalsDomain,
	val imageDomain : ImageDomain,
	val summary : String,
	val updated : Int,
	val linksDomain : LinksDomain
)