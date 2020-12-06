package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.EpisodeResponse
import com.schaefer.mymovies.domain.model.ListEpisodeDomain

class ListEpisodeDomainMapper(private val mapperEpisodeDomainMapper: EpisodeDomainMapper) :
    Mapper<EpisodeResponse, ListEpisodeDomain> {
    override fun map(source: EpisodeResponse): ListEpisodeDomain {
        return ListEpisodeDomain(listOfEpisodes = source.map { mapperEpisodeDomainMapper.map(it) })
    }
}