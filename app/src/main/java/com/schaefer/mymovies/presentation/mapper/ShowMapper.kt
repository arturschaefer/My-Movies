package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ShowData
import com.schaefer.mymovies.domain.model.*
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
            schedule = scheduleMapper.map(source.scheduleDomain),
            rating = ratingMapper.map(source.ratingDomain),
            weight = source.weight,
            network = networkMapper.map(source.networkDomain),
            webChannel = webChannelMapper.map(source.webChannelDomain),
            externals = externalsMapper.map(source.externalsDomain),
            image = imageMapper.map(source.imageDomain),
            summary = source.summary,
            updated = source.updated,
            links = linksMapper.map(source.linksDomain)
        )
    }

}