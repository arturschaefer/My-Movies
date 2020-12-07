package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.domain.model.EpisodeDomain
import com.schaefer.mymovies.presentation.model.Episode

class EpisodeMapper(val linksMapper: LinksMapper, val imageMapper: ImageMapper) :
    Mapper<EpisodeDomain, Episode> {
    override fun map(source: EpisodeDomain): Episode {
        return Episode(
            _links = source._links?.let { linksMapper.map(it) },
            airdate = source.airdate,
            airstamp = source.airstamp,
            airtime = source.airtime,
            id = source.id,
            image = source.image?.let { imageMapper.map(it) },
            name = source.name,
            number = source.number,
            runtime = source.runtime,
            season = source.season,
            summary = source.summary,
            type = source.type,
            url = source.url
        )
    }

}
