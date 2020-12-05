package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ExternalsData
import com.schaefer.mymovies.domain.model.ExternalsDomain

class ExternalsDomainMapper : Mapper<ExternalsData, ExternalsDomain> {
    override fun map(source: ExternalsData): ExternalsDomain {
        return ExternalsDomain(
            tvrage = source.tvrage,
            thetvdb = source.thetvdb,
            imdb = source.imdb
        )
    }
}