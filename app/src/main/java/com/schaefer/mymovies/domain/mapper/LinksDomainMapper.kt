package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.LinksData
import com.schaefer.mymovies.domain.model.LinksDomain

class LinksDomainMapper(
    private val previousEpisodeDomainMapper: PreviousEpisodeDomainMapper,
    private val selfDomainMapper: SelfDomainMapper
) : Mapper<LinksData, LinksDomain> {
    override fun map(source: LinksData): LinksDomain {
        return LinksDomain(
            selfDomain = selfDomainMapper.map(source.selfData),
            previousEpisodeDomain = previousEpisodeDomainMapper.map(source.previousEpisodeData)
        )
    }
}