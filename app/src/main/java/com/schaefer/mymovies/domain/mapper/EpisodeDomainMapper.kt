package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.EpisodeResponseItem
import com.schaefer.mymovies.domain.model.EpisodeDomain

class EpisodeDomainMapper(
    private val mapperLinks: LinksDomainMapper,
    private val mapperImage: ImageDomainMapper
) :
    Mapper<EpisodeResponseItem, EpisodeDomain> {
    override fun map(source: EpisodeResponseItem): EpisodeDomain {
        return EpisodeDomain(
            _links = source._links?.let { mapperLinks.map(it) },
            airdate = source.airdate,
            airstamp = source.airstamp,
            airtime = source.airtime,
            id = source.id,
            image = source.image?.let { mapperImage.map(it) },
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