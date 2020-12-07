package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.domain.model.ExternalsDomain
import com.schaefer.mymovies.presentation.model.Externals

class ExternalsMapper : Mapper<ExternalsDomain, Externals> {
    override fun map(source: ExternalsDomain): Externals {
        return Externals(
            tvrage = source.tvrage,
            thetvdb = source.thetvdb,
            imdb = source.imdb
        )
    }
}