package com.schaefer.mymovies.presentation.model

data class Show (
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
	val schedule : Schedule,
	val rating : Rating,
	val weight : Int,
	val network : Network,
	val webChannel : WebChannel,
	val externals : Externals,
	val image : Image,
	val summary : String,
	val updated : Int,
	val links : Links
)