package com.schaefer.mymovies.data.model

data class SearchResponseItem(
    val score: Double,
    val show: ShowResponseItem
)