package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.domain.model.ShowDomain
import com.schaefer.mymovies.presentation.model.Show

class ShowMapper(
    private val scheduleMapper: ScheduleMapper,
    private val ratingMapper: RatingMapper,
    private val networkMapper: NetworkMapper,
    private val webChannelMapper: WebChannelMapper,
    private val externalsMapper: ExternalsMapper,
    private val imageMapper: ImageMapper,
    private val linksMapper: LinksMapper
) : Mapper<ShowDomain, Show> {

    override fun map(source: ShowDomain): Show {
        return Show(
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
            schedule = source.scheduleDomain?.let { scheduleMapper.map(it) },
            rating = source.ratingDomain?.let { ratingMapper.map(it) },
            weight = source.weight,
            network = source.networkDomain?.let { networkMapper.map(it) },
            webChannel = source.webChannelDomain?.let { webChannelMapper.map(source.webChannelDomain) },
            externals = source.externalsDomain?.let { externalsMapper.map(it) },
            image = source.imageDomain?.let { imageMapper.map(it) },
            summary = source.summary,
            updated = source.updated,
            links = source.linksDomain?.let { linksMapper.map(it) }
        )
    }

}