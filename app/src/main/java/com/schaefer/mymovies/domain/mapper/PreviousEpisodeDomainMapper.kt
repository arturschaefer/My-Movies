package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.PreviousEpisodeData
import com.schaefer.mymovies.domain.model.PreviousEpisodeDomain

class PreviousEpisodeDomainMapper : Mapper<PreviousEpisodeData, PreviousEpisodeDomain> {
    override fun map(source: PreviousEpisodeData): PreviousEpisodeDomain {
        return PreviousEpisodeDomain(source.href)
    }
}