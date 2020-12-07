package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.domain.model.ListEpisodeDomain
import com.schaefer.mymovies.presentation.model.ListEpisode

class ListEpisodeMapper(val mapper: EpisodeMapper): Mapper<ListEpisodeDomain, ListEpisode> {
    override fun map(source: ListEpisodeDomain): ListEpisode {
        return ListEpisode(
            listOfEpisodes = source.listOfEpisodes.map { mapper.map(it) }
        )
    }
}