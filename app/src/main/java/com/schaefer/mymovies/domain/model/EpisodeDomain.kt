package com.schaefer.mymovies.domain.model

data class EpisodeDomain(
    val _links: LinksDomain?,
    val airdate: String?,
    val airstamp: String?,
    val airtime: String?,
    val id: Int,
    val image: ImageDomain?,
    val name: String?,
    val number: Int?,
    val runtime: Int?,
    val season: Int?,
    val summary: String?,
    val type: String?,
    val url: String?
)