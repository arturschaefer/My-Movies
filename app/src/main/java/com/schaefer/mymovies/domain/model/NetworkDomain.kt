package com.schaefer.mymovies.domain.model

data class NetworkDomain (
	val id : Int,
	val name : String,
	val countryDomain : CountryDomain
)