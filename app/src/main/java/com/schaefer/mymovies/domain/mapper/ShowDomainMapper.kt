package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ShowResponseItem
import com.schaefer.mymovies.domain.model.ShowDomain

class ShowDomainMapper(
    private val scheduleDomainMapper: ScheduleDomainMapper,
    private val ratingDomainMapper: RatingDomainMapper,
    private val networkDomainMapper: NetworkDomainMapper,
    private val webChannelMapper: WebChannelMapper,
    private val externalsDomainMapper: ExternalsDomainMapper,
    private val imageDomainMapper: ImageDomainMapper,
    private val linksDomainMapper: LinksDomainMapper
) : Mapper<ShowResponseItem, ShowDomain> {


    override fun map(source: ShowResponseItem): ShowDomain {

        return ShowDomain(
            id = source.id,
            url = source.url.orEmpty(),
            name = source.name.orEmpty(),
            type = source.type.orEmpty(),
            language = source.language.orEmpty(),
            genres = source.genres ?: emptyList(),
            status = source.status.orEmpty(),
            runtime = source.runtime ?: 0,
            premiered = source.premiered.orEmpty(),
            officialSite = source.officialSite.orEmpty(),
            scheduleDomain = source.schedule?.let { scheduleDomainMapper.map(it) },
            ratingDomain = source.rating?.let { ratingDomainMapper.map(it) },
            weight = source.weight ?: 0,
            networkDomain = source.network?.let { networkDomainMapper.map(it) },
            webChannelDomain = source.webChannel?.let { webChannelMapper.map(source.webChannel) },
            externalsDomain = source.externals?.let { externalsDomainMapper.map(it) },
            imageDomain = source.image?.let { imageDomainMapper.map(it) },
            summary = source.summary.orEmpty(),
            updated = source.updated ?: 0,
            linksDomain = source._links?.let { linksDomainMapper.map(it) }
        )
    }

}