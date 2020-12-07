package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Externals
import com.schaefer.mymovies.domain.model.ExternalsDomain

class ExternalsDomainMapper : Mapper<Externals, ExternalsDomain> {
    override fun map(source: Externals): ExternalsDomain {
        return ExternalsDomain(
            tvrage = source.tvrage ?: 0,
            thetvdb = source.thetvdb ?: 0,
            imdb = source.imdb.orEmpty()
        )
    }
}