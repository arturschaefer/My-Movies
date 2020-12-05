package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Links
import com.schaefer.mymovies.domain.model.LinksDomain

class LinksDomainMapper(
    private val previousEpisodeDomainMapper: PreviousEpisodeDomainMapper,
    private val selfDomainMapper: SelfDomainMapper
) : Mapper<Links, LinksDomain> {
    override fun map(source: Links): LinksDomain {
        return LinksDomain(
            selfDomain = source.self?.let { selfDomainMapper.map(it) },
            previousEpisodeDomain = source.previousepisode?.let { previousEpisodeDomainMapper.map(it) }
        )
    }
}