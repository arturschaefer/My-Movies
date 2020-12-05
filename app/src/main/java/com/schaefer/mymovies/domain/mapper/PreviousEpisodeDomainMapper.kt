package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Previousepisode
import com.schaefer.mymovies.domain.model.PreviousEpisodeDomain

class PreviousEpisodeDomainMapper : Mapper<Previousepisode, PreviousEpisodeDomain> {
    override fun map(source: Previousepisode): PreviousEpisodeDomain {
        return PreviousEpisodeDomain(source.href.orEmpty())
    }
}