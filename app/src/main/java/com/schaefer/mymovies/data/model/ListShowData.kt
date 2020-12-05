package com.schaefer.mymovies.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ListShowData(val listShows: List<ShowData>)