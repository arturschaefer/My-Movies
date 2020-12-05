package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.PreviousEpisodeData
import com.schaefer.mymovies.domain.model.PreviousEpisodeDomain
import com.schaefer.mymovies.presentation.model.PreviousEpisode

class PreviousEpisodeMapper : Mapper<PreviousEpisodeDomain, PreviousEpisode> {
    override fun map(source: PreviousEpisodeDomain): PreviousEpisode {
        return PreviousEpisode(source.href)
    }
}