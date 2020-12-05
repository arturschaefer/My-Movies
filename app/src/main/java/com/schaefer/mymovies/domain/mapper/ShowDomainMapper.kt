package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ShowData
import com.schaefer.mymovies.domain.model.*

class ShowDomainMapper(private val scheduleDomainMapper: ScheduleDomainMapper,
                       private val ratingDomainMapper: RatingDomainMapper,
                       private val networkDomainMapper: NetworkDomainMapper,
                       private val webChannelMapper: WebChannelMapper,
                       private val externalsDomainMapper: ExternalsDomainMapper,
                       private val imageDomainMapper: ImageDomainMapper,
                       private val linksDomainMapper: LinksDomainMapper): Mapper<ShowData, ShowDomain> {


    override fun map(source: ShowData): ShowDomain {

        return ShowDomain(
            id = source.id,
            url = source.url,
            name = source.name,
            type = source.type,
            language = source.language,
            genres = source.genres,
            status = source.status,
            runtime = source.runtime,
            premiered = source.premiered,
            officialSite = source.officialSite,
            scheduleDomain = scheduleDomainMapper.map(source.scheduleData),
            ratingDomain = ratingDomainMapper.map(source.ratingData),
            weight = source.weight,
            networkDomain = networkDomainMapper.map(source.networkData),
            webChannelDomain = webChannelMapper.map(source.webChannelData),
            externalsDomain= externalsDomainMapper.map(source.externalsData),
            imageDomain= imageDomainMapper.map(source.imageData),
            summary = source.summary,
            updated = source.updated,
            linksDomain = linksDomainMapper.map(source.linksData)
        )
    }

}